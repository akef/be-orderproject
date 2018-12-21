package com.test.order.dto;

public class PaymentRuleDto {


	private String ruleName;
	private String action;


	public PaymentRuleDto(String ruleName, String action) {
		super();
		this.ruleName = ruleName;
		this.action = action;
	}
	
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	
}
