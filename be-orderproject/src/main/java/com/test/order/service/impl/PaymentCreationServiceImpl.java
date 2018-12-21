package com.test.order.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.order.dao.PaymentRulesDao;
import com.test.order.dto.PaymentRuleDto;
import com.test.order.entity.PaymentRules;
import com.test.order.service.PaymentCreationService;

@Service
public class PaymentCreationServiceImpl implements PaymentCreationService {

	@Autowired
	PaymentRulesDao paymentRulesDao;

	@Override
	public boolean createRule(PaymentRuleDto paymentRuleDto) {
		PaymentRules paymentRules = new PaymentRules(paymentRuleDto.getRuleName(), paymentRuleDto.getAction());
		try {
			paymentRulesDao.save(paymentRules);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<PaymentRuleDto> getAllRules() {
		List<PaymentRules> paymentRules = (List<PaymentRules>) paymentRulesDao.findAll();
		if (paymentRules == null || paymentRules.isEmpty()) {
			return new ArrayList<PaymentRuleDto>();
		}
		List<PaymentRuleDto> listofPaymentRuleDto = new ArrayList<PaymentRuleDto>();
		for (int i = 0; i < paymentRules.size(); i++) {
			PaymentRuleDto paymentRuleDto = new PaymentRuleDto(
					paymentRules.get(i).getRuleName(), paymentRules.get(i).getAction());
			listofPaymentRuleDto.add(paymentRuleDto);
		}
		return listofPaymentRuleDto;
	}

	@Override
	public PaymentRuleDto changeRule(PaymentRuleDto paymentRuleDto, Long id) {
		PaymentRules newPaymentRules = new PaymentRules(paymentRuleDto.getRuleName(), paymentRuleDto.getAction());
		try {
			paymentRulesDao.findById(id).map(paymentRules -> {
				paymentRules.setRuleName(newPaymentRules.getRuleName());
				paymentRules.setAction(newPaymentRules.getAction());
				return paymentRulesDao.save(paymentRules);
			}).orElseGet(() -> {
				newPaymentRules.setId(id);
				return paymentRulesDao.save(newPaymentRules);
			});
			return paymentRuleDto;
		} catch (Exception e) {
			return null;
		}

	}

}
