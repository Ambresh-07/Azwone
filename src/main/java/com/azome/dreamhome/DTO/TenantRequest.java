package com.azome.dreamhome.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TenantRequest {
	
	@NotNull(message = "Name should not be Null")
	private String name;
	
//	@Pattern(regexp = "^\\d{10}$",message = "enter correct contact...")
//	@NotNull(message = "contact shold not be null")
	@Min(10)
	private Long contact;
	
	@Email(message = "Enter valid email...")
	private String email;
	
	@NotEmpty(message = "address should not be blank...")
	private String address;

}
