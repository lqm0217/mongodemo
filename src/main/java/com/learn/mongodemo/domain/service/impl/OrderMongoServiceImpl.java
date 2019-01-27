package com.learn.mongodemo.domain.service.impl;

import com.learn.mongodemo.domain.entity.OrderSummaryMongo;
import com.learn.mongodemo.domain.repository.OrderSummaryMongoRepository;
import com.learn.mongodemo.domain.service.OrderMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderMongoServiceImpl implements OrderMongoService {

	@Autowired
	private OrderSummaryMongoRepository orderSummaryRepository;

	@Override
	public OrderSummaryMongo getOrderById(String id) throws Exception {
		Optional<OrderSummaryMongo> orderSummary = orderSummaryRepository.findById(id);

		return orderSummary.orElseThrow(() -> new NullPointerException("no data"));
	}

	@Override
	public List<OrderSummaryMongo> getOrders(OrderSummaryMongo orderSummary) throws Exception {
		Iterable<OrderSummaryMongo> searchResult = orderSummaryRepository.findAll();

		return (List<OrderSummaryMongo>) searchResult;
	}

	@Override
	public OrderSummaryMongo saveOrder(OrderSummaryMongo orderSummary) throws Exception {
		return orderSummaryRepository.save(orderSummary);
	}
}
