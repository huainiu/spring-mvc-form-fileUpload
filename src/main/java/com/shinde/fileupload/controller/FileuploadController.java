package com.shinde.fileupload.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.shinde.fileupload.model.FileUpload;

public class FileuploadController extends SimpleFormController {

	public FileuploadController() {
		setCommandClass(FileUpload.class);
		setCommandName("FileUploadForm");

	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		FileUpload file = (FileUpload)command;
		 
		MultipartFile multipartFile = file.getFile();
 
		String fileName="";
 
		if(multipartFile!=null){
			fileName = multipartFile.getOriginalFilename();
			//do whatever you want
			System.out.println("File is uploaded to server");
		}
 
		return new ModelAndView("FileUploadSuccess","fileName",fileName);

	}

	

}
