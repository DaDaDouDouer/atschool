package com.gs.reusebook.service;

import static com.gs.reusebook.util.GlobalStatus.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.gs.reusebook.bean.Seller;
import com.gs.reusebook.bean.User;
import com.gs.reusebook.bean.base.AuthBaseBean;
import com.gs.reusebook.dao.SellerDao;
import com.gs.reusebook.dao.UserDao;
import com.gs.reusebook.util.SecurityCodeGenerate;
import com.gs.reusebook.util.SecurityImageGenerate;
import com.gs.reusebook.util.UiReturn;

@Service
public class AuthService {
	
	@Autowired
	UserDao userDao;
	@Autowired
	SellerDao sellerDao;
	
	@Autowired
	MailSender mailSender;
	@Autowired
	SimpleMailMessage templateMessage;
	
	public String getCheckCode(HttpServletResponse response){
		
		String securityCode = SecurityCodeGenerate.getSecurityCode();
		
		ByteArrayInputStream imageStream = SecurityImageGenerate.getImageAsInputStream(securityCode);
		
		response.setContentType("image/jpeg");
		try {
			byte[] b = new byte[imageStream.available()];
			imageStream.read(b);
			OutputStream out = response.getOutputStream();
			out.write(b);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (imageStream != null) {
				try {
					imageStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return securityCode;
	}
	
	public UiReturn findPassword(String username){
		List<User> users = userDao.selectByName(username);
		AuthBaseBean authBean = null;
		if(users == null || users.isEmpty()){
			
			List<Seller> sellers = sellerDao.selectByName(username);
			if(sellers == null || sellers.isEmpty()){
				return UiReturn.notOk("", "", REQ_ERROR_400);
			}else{
				authBean = sellers.get(0);
			}
		}else{
			authBean = users.get(0);
		}
		
		// 通过邮件模版构建出一个邮件
		SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
		// 设置相关属性
		// mailInf中按照顺序放置了收件人，主题和内容
		msg.setTo(authBean.getMail());
		msg.setSubject("密码找回邮件");
		msg.setText("用户：" + authBean.getUsername() + " 的密码是：" + authBean.getPassword());
		
		// 发送
		try {
			mailSender.send(msg);
		} catch (MailException e) {
			e.printStackTrace();
			return UiReturn.notOk("", e.getMessage(), SERVICE_ERROR_500);
		}
		
		return UiReturn.ok("", "发送成功");
	}
}
