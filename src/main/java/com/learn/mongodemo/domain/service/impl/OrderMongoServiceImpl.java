package com.learn.mongodemo.domain.service.impl;

import com.learn.mongodemo.domain.entity.OrderSummaryMongo;
import com.learn.mongodemo.domain.repository.OrderSummaryMongoRepository;
import com.learn.mongodemo.domain.service.OrderMongoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
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
		Example<OrderSummaryMongo> example = Example.of(orderSummary);

		List<OrderSummaryMongo> searchResult = orderSummaryRepository.findAll(example);

		return searchResult;
	}

	@Override
	public OrderSummaryMongo saveOrder(OrderSummaryMongo orderSummary) throws Exception {

		Optional<OrderSummaryMongo> orderSummaryOptional = getOrderByUk(orderSummary);

		OrderSummaryMongo returnValue;
		if (orderSummaryOptional.isPresent()) {
			OrderSummaryMongo orderSummaryTemp = orderSummaryOptional.get();
			if (orderSummary.getExpectDeleverDate() != null) {
				orderSummaryTemp.setExpectDeleverDate(orderSummary.getExpectDeleverDate());
			}
			returnValue = orderSummaryRepository.save(orderSummaryTemp);
		} else {
			orderSummary.setRequestTime(LocalDateTime.now());
			orderSummary.setCancelFlag(false);
			returnValue = orderSummaryRepository.save(orderSummary);
		}
		return returnValue;
	}

	@Override
	public OrderSummaryMongo cancleOrder(OrderSummaryMongo orderSummary) throws Exception {

		Optional<OrderSummaryMongo> orderSummaryOptional = getOrderByUk(orderSummary);

		OrderSummaryMongo returnValue;
		if (orderSummaryOptional.isPresent()) {
			OrderSummaryMongo orderSummaryTemp = orderSummaryOptional.get();
			orderSummaryTemp.setCancelFlag(true);
			returnValue = orderSummaryRepository.save(orderSummaryTemp);
		} else {
			log.error("Order not found!");
			throw new Exception("Order not found!");
		}
		return returnValue;
	}

	private Optional<OrderSummaryMongo> getOrderByUk(OrderSummaryMongo orderSummary) throws Exception {

		OrderSummaryMongo searchOrderSummaryMongo = new OrderSummaryMongo();
		searchOrderSummaryMongo.setUserId(orderSummary.getUserId());
		searchOrderSummaryMongo.setZip(orderSummary.getZip());

		Example<OrderSummaryMongo> example = Example.of(searchOrderSummaryMongo);
		Optional<OrderSummaryMongo> orderSummaryOptional = orderSummaryRepository.findOne(example);

		return orderSummaryOptional;
	}
}
