package com.test.order.dao;

import org.springframework.data.repository.CrudRepository;

import com.test.order.entity.PaymentRules;

public interface PaymentRulesDao extends CrudRepository<PaymentRules,Long>{
}
