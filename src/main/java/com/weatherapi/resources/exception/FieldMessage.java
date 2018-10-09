package com.weatherapi.resources.exception;

import java.io.Serializable;

/**
 * @class The FieldMessage class provides the message model when there is an error
 * at creating a new city or estate
 * 
 * @author  João Paulo (vilarjp3@ufrn.edu.br)
 * @author  Luis Eduardo  (cruxiu@ufrn.edu.br)
 * @version 08.10.2018
 */
public class FieldMessage implements Serializable {
	private static final long serialVersionUID = 1;
	
	private String fieldName;
	private String message;
	
	public FieldMessage() {
		
	}

	public FieldMessage(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
