package com.azome.dreamhome.DTO;

import java.util.List;

import com.azome.dreamhome.entity.Owner;
import com.azome.dreamhome.entity.Property;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BrokerRequest {
	
	private String name;
	private Integer contact;
	private String email;


}
