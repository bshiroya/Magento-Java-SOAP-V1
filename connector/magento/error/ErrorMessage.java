package com.connector.magento.error;

public enum ErrorMessage {

	ACCESS_DENIED("Access denied.");

	private String error;

	ErrorMessage(String error) {
		this.error = error;
	}

	public String getError() {
		return this.error;
	}

}
