package com.github.wdeqin.flyit.web.experiment;

import java.util.Map;

public class RmiPack {
	private String processCode;
	private Map<String, Object> input; 

	public String getProcessCode() {
		return processCode;
	}

	public void setProcessCode(String processCode) {
		this.processCode = processCode;
	}

	public Map<String, Object> getInput() {
		return input;
	}

	public void setInput(Map<String, Object> input) {
		this.input = input;
	}
}
