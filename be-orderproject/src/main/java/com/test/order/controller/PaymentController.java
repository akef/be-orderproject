package com.test.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;
import com.test.order.dto.PaymentRuleDto;
import com.test.order.service.PaymentCreationService;

@RestController
public class PaymentController {

	@Autowired
	PaymentCreationService paymentCreationService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<String> createRule(@RequestBody PaymentRuleDto paymentRuleDto) {
		try {
			Preconditions.checkNotNull(paymentRuleDto);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		if (paymentCreationService.createRule(paymentRuleDto)) {
			return new ResponseEntity<>(null, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.FAILED_DEPENDENCY);

		}

	}
}
