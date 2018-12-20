package com.test.order.service;

import com.test.order.dto.PaymentRuleDto;

public interface PaymentCreationService {

	boolean createRule(PaymentRuleDto paymentRuleDto);
}
