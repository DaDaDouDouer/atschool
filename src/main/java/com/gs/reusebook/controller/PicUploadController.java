package com.gs.reusebook.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping(value = "/get/{picId}", method = RequestMethod.GET)
	public void getPic(@PathVariable("picId") String picId, HttpServletResponse response) {
		
		picUploadService.get(picId, response);
	}
	
	/*
	 *  得到适用于html img标签的src属性的url值
	 */
	static public String getPicUrl(String picId){
		return "/file/pic/get/" + picId + ".do";
	}
	
}