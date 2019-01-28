package com.learn.mongodemo.domain.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection="order_summary")
@CompoundIndexes({
		@CompoundIndex(name = "uk_idx_1", def = "{'userId': 1, 'zip': 1}")
})
public class OrderSummaryMongo {
	@Id
	private String id;

	@Field("user_id")
	private Integer userId;

	private String zip;

	@Field("request_time")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime requestTime;

	@Field("expect_delever_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate expectDeleverDate;

	@Field("cancel_flag")
	private Boolean cancelFlag;

}
