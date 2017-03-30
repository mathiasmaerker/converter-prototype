package com.tts.scp.converter;

import java.util.Map;

public class Converter {
	
	private Map<String, String> printOptions;
	private String applicationId;
	
	public Converter() {
		super();
	}

	public Map<String, String> getPrintOptions() {
		return printOptions;
	}

	public void setPrintOptions(Map<String, String> printOptions) {
		this.printOptions = printOptions;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	
		
}
