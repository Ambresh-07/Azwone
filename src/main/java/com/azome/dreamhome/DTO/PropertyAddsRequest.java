package com.azome.dreamhome.DTO;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyAddsRequest {

	@NotEmpty(message = "title should not be Null/empty")
	private String title;

	@NotEmpty(message = "summery should not be null")
	private String summary;

	@NotNull(message = "ren_amount should not empty")
	@Min(1)
	private double rental_amont;

	@Min(1)
	@NotNull(message = "sell_price should not empty")
	private double sell_price;

	@NotBlank(message = "add_type should not be null")
	private String add_type;

	@NotBlank(message = "owner should not be null")
	private String owner;

	@NotNull(message = "Property age should not be null")
	@Max(3)
	private String propertyage;

	@DecimalMin(value = "1.0", message = "Please Enter a valid Deposit Amount")
	private double deposite;



	
	
	

}
