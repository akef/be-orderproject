package com.test.order.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PaymentRules {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	private String ruleName;
	private String action;
	
	

	
	public PaymentRules() {
		super();
	}
	public PaymentRules(String ruleName, String action) {
		super();
		this.ruleName = ruleName;
		this.action = action;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
