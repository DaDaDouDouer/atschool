package com.gs.reusebook.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gs.reusebook.controller.PicUploadController;
import com.gs.reusebook.util.UiReturn;

@Service
public class PicUploadService {
	
	// TODO 这个盘符可能需要修改，适配windows linux
	private static final String PATH_WIN = "M:/graduate_files/";
	
	public UiReturn upload(MultipartFile file){
			// TODO 校验

			String fileName = file.getOriginalFilename();
	
			// 图片扩展名
			String ext = fileName.substring(fileName.lastIndexOf("."));
			String picId = UUID.randomUUID().toString() + ext;
			
			// 保存图片到硬盘
			File targetFile = new File(PATH_WIN, picId);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			try {
				file.transferTo(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}

			return UiReturn.ok(PicUploadController.getPicUrl(picId), "上传成功");
	}
	
	public void get(String picId, HttpServletResponse response){

		FileInputStream fis = null;
		try {
			
			File file = new File(PATH_WIN + picId);
			String ext = picId.substring(picId.indexOf(".") + 1);
			
			response.setContentType("image/" + ext);
			
			fis = new FileInputStream(file);
			byte[] b = new byte[fis.available()];
			fis.read(b);
			OutputStream out = response.getOutputStream();
			out.write(b);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
