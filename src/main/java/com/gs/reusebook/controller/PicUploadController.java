package com.gs.reusebook.controller;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gs.reusebook.annotation.NeedUserLogin;
import com.gs.reusebook.bean.Seller;
import com.gs.reusebook.bean.User;
import com.gs.reusebook.service.PicUploadService;
import com.gs.reusebook.util.UiReturn;

@Controller
@RequestMapping("/file/pic")
public class PicUploadController {

	@Autowired
	private PicUploadService picUploadService;
	

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@NeedUserLogin(character = {Seller.class, User.class})
	@ResponseBody
	public UiReturn upload(@RequestParam(value = "file", required = false) MultipartFile file) {

		return picUploadService.upload(file);
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public void getPic(@RequestParam(value="picId") String picId, HttpServletResponse response) {
		
		picUploadService.get(picId, response);
	}
	
	/**
	 * 图片url值
	 */
	private final static String PIC_URI;
	
	/**
	 *  通过获取注解值组装图片url
	 */
	static{
		// 默认值
		String classMappingUri = "/file/pic";
		String methodMappingUri = "/get";
		String firstParamName = "picId";
		try {
		// TODO 校验，存不存在之类的
			classMappingUri = PicUploadController.class.getAnnotation(RequestMapping.class).value()[0];
			
			Method getPicMethod = PicUploadController.class.getMethod("getPic", String.class, HttpServletResponse.class);
			methodMappingUri = getPicMethod.getAnnotation(RequestMapping.class).value()[0];
			
			// 不使用java1.8，不能纯通过反射获取参数名，要分析.class文件
			firstParamName = ((RequestParam)getPicMethod.getParameterAnnotations()[0][0]).value();
			
		} catch (Exception e){
			// TODO 日志之类的
		}
		PIC_URI = classMappingUri + methodMappingUri + ".do?" + firstParamName + "=";
	}
	
	/*
	 *  得到适用于html img标签的src属性的url值
	 */
	static public String getPicUrl(String picId){
		return PIC_URI + picId;
	}
	
}