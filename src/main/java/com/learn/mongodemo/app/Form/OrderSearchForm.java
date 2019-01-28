package com.learn.mongodemo.app.Form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderSearchForm {

    @Size(max = 10)
    private String userId;

    @Size(max = 10)
    private String zip;

    @Size(max = 10)
    private String requestTime;

    @Size(max = 1)
    private String cancelFlag;

    @Size(max = 10)
    private String expectDeleverDate;
}
