package com.nilzxq.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@Controller
public class UploadController {
 @RequestMapping("/upload")
	public String upload(@RequestParam("file")MultipartFile file){
	 //文件的原名称
	 String originalFilename = file.getOriginalFilename();
	 //文件的大小
	 long size=file.getSize();
	 System.out.println("originalFilename:"+originalFilename);
	 System.out.println("size:"+size);
	 String path="E://nilzxq";
	 File targetFile = new File(path,originalFilename);
	 if(!targetFile.exists()){
		 targetFile.mkdirs();
	 }
	 //保存文件
	 try {
		file.transferTo(targetFile);
	} catch (IllegalStateException e) {
	System.out.println("error"+e.getMessage());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("error"+e.getMessage());
	}
		return "success";
	}
}
