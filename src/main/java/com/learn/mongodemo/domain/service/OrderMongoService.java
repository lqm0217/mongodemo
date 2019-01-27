package com.learn.mongodemo.domain.service;

import com.learn.mongodemo.domain.entity.OrderSummaryMongo;

import java.util.List;

public interface OrderMongoService {

	OrderSummaryMongo getOrderById(String id) throws Exception;

	List<OrderSummaryMongo> getOrders(OrderSummaryMongo orderSummary) throws Exception;

	OrderSummaryMongo saveOrder(OrderSummaryMongo orderSummary) throws Exception;

}
