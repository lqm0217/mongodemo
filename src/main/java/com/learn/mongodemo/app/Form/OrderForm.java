package com.learn.mongodemo.app.Form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderForm implements Serializable {

	private static final long serialVersionUID = 5295347059613662935L;

	@NotBlank
	@Size(max = 10)
	private String requestTime;

	@NotBlank
	@Size(max = 1)
	@Range(min = 0, max = 1)
	private String cancelFlag;

	@NotBlank
	@Size(max = 10)
	private String userId;

	@NotBlank
	@Size(max = 10)
	private String zip;
}
