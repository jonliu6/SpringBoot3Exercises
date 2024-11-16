package org.freecode.demo.springboot3mvccrud.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailFormatConstraintValidator implements ConstraintValidator<EmailFormat, String>{
	
	private String emailChar;
	
	@Override
	public void initialize(EmailFormat theEmailFormat) {
		emailChar = theEmailFormat.value();
	}

	@Override
	public boolean isValid(String theEmail, ConstraintValidatorContext context) {
		boolean result;
		
		if (theEmail != null ) {
			result = theEmail.contains(emailChar);
			
		}
		else {
			result = false;
		}
		
		return result;
	}

}
