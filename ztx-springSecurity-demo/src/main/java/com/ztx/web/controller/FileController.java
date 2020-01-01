package com.ztx.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ztx.dto.FileInfo;

@RestController
@RequestMapping("/file")
public class FileController {
	String path = "G:/myworkspeake/imooc/ztx-springSecurity-demo/src/main/java/com/ztx/web/controller";
	
	@PostMapping
	private FileInfo fileUpload(MultipartFile file) throws IllegalStateException, IOException {
		System.out.println(file.getName());//文件名
		System.out.println(file.getSize());//大小
		System.out.println(file.getOriginalFilename());//旧文件名
		File uploadfile = new File(path ,new Date().getTime()+".txt");
		file.transferTo(uploadfile);//内存内容写到硬盘
		return new FileInfo(uploadfile.getAbsolutePath());
	}
	/**
	 * 指定文件读取
	 * @param request
	 * @param response
	 * @param id
	 */
	@GetMapping("/{id}")
	public void download(HttpServletRequest request ,HttpServletResponse response ,@PathVariable(name="id") String id) {
		System.out.println("file read open");
		try (//1.7以后新功能，可省去自动关流
				InputStream is = new FileInputStream(new File(path,id+".txt"));//指定路径读取指定名称的file
				OutputStream os = response.getOutputStream();//
			){
			response.setContentType("application/x-download");//输出文件类型
			response.setHeader("Pragma", "No-cache"); 
		    response.setHeader("Content-disposition", "attachment;filename=test.txt");//输出文件名   filename-test
			IOUtils.copy(is, os);
			os.flush();
		}catch(Exception e) {
			
		}
		System.out.println("file read end");
	}
}
