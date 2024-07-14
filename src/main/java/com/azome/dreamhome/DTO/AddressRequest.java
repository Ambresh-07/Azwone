package com.azome.dreamhome.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {
	
	private String landmark;
	private String street;
	private String city;
	private Integer pincode;

}
