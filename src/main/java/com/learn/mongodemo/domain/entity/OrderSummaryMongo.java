package com.learn.mongodemo.domain.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderSummaryMongo {
	@Id
	private String id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate requestTime;

	private Boolean cancelFlag;

	private Integer userId;

	private String zip;
}
