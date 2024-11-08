package org.freecode.demo.springboot3mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailFormatConstraintValidator implements ConstraintValidator<EmailFormat, String>{
	
	private String emailSuffix;
	
	@Override
	public void initialize(EmailFormat theEmailFormat) {
		emailSuffix = theEmailFormat.value();
	}

	@Override
	public boolean isValid(String theEmail, ConstraintValidatorContext context) {
		boolean result;
		
		if (theEmail != null ) {
			result = theEmail.endsWith(emailSuffix);
			
		}
		else {
			result = false;
		}
		
		return result;
	}

}
