package com.learn.mongodemo.app.controller;

import com.learn.mongodemo.app.Form.OrderForm;
import com.learn.mongodemo.app.Form.OrderSearchForm;
import com.learn.mongodemo.domain.entity.OrderSummaryMongo;
import com.learn.mongodemo.domain.service.OrderMongoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * get order information.
 */
@RestController
@Validated
@RequestMapping("/api/orderMongo")
@Api(value = "OrderMongoController")
public class OrderMongoController {

	@Autowired
	OrderMongoService orderService;

	/**
	 * get single order summary information by id.
	 */
	@GetMapping(value = "/getOrder/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@ApiOperation(value = "getOrder", notes = "getOrder", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public OrderSummaryMongo getOrder(@PathVariable(value = "id") String id) throws Exception {

		return orderService.getOrderById(id);
	}

	@PostMapping(value = "/getOrders", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@ApiOperation(value = "getOrders", notes = "getOrders", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<OrderSummaryMongo> getOrders(@Validated OrderSearchForm from) throws Exception {

		OrderSummaryMongo orderSummary = new OrderSummaryMongo();
		//orderSummary.setCancelFlag("0".equals(from.getCancelFlag()) ? false : true);
		//orderSummary.setUserId(Integer.valueOf(from.getUserId()));
		orderSummary.setZip(from.getZip());
		//orderSummary.setRequestTime(LocalDate.parse(from.getRequestTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));

		return orderService.getOrders(orderSummary);
	}

	/**
	 * get single order summary information by id.
	 */
	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	@ApiOperation(value = "create", notes = "create", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public OrderSummaryMongo create(@Validated OrderForm from) throws Exception {

		// TODO bean copy
		OrderSummaryMongo orderSummary = new OrderSummaryMongo();
		orderSummary.setCancelFlag("0".equals(from.getCancelFlag()) ? false : true);
		orderSummary.setUserId(Integer.valueOf(from.getUserId()));
		orderSummary.setZip(from.getZip());
		orderSummary.setRequestTime(LocalDate.parse(from.getRequestTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));

		return orderService.saveOrder(orderSummary);
	}
}
