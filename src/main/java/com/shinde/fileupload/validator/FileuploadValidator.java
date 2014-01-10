package com.shinde.fileupload.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shinde.fileupload.model.FileUpload;

public class FileuploadValidator implements Validator {

	@Override
	public boolean supports(@SuppressWarnings("rawtypes") Class claszz) {
		// just validate the customer instance
		return FileUpload.class.isAssignableFrom(claszz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		FileUpload file = (FileUpload)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "file",
				"required.fileUpload", "Please select a file!");
		 
		if(file.getFile().getSize()==0){
			errors.rejectValue("file", "required.fileUpload");
		}

	}

}
