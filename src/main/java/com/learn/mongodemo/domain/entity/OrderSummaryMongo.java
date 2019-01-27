package com.learn.mongodemo.domain.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection="order_summary")
public class OrderSummaryMongo {
	@Id
	private String id;

	@Field("request_time")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate requestTime;

	@Field("cancel_flag")
	private Boolean cancelFlag;

	@Indexed()
	@Field("user_id")
	private Integer userId;

	private String zip;
}
