package com.learn.mongodemo.app.Form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderBaseForm implements Serializable {

	@NotBlank
	@Size(max = 10)
	private String userId;

	@NotBlank
	@Size(max = 10)
	private String zip;

}
