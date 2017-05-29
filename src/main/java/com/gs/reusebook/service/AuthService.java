package com.gs.reusebook.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.gs.reusebook.util.SecurityCodeGenerate;
import com.gs.reusebook.util.SecurityImageGenerate;

@Service
public class AuthService {
	
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
	
}
