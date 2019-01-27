package com.learn.mongodemo.app.Form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderSearchForm implements Serializable {

	private static final long serialVersionUID = -7839495979840777563L;

	@Size(max = 10)
	private String requestTime;

	@Size(max = 1)
	private String cancelFlag;

	@Size(max = 10)
	private String userId;

	@Size(max = 10)
	private String zip;
}
