package com.test.order.service;

import java.util.List;

import com.test.order.dto.PaymentRuleDto;

public interface PaymentCreationService {

	boolean createRule(PaymentRuleDto paymentRuleDto);
	List<PaymentRuleDto> getAllRules();
	PaymentRuleDto changeRule(PaymentRuleDto paymentRuleDto,Long id);
}
