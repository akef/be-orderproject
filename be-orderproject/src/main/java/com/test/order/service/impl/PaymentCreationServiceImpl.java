package com.test.order.service.impl;

import org.springframework.stereotype.Service;

import com.test.order.dto.PaymentRuleDto;
import com.test.order.service.PaymentCreationService;

@Service
public class PaymentCreationServiceImpl implements PaymentCreationService{

	@Override
	public boolean createRule(PaymentRuleDto paymentRuleDto) {
		
		return false;
	}

}
