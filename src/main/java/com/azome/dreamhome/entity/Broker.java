package com.azome.dreamhome.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Broker {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private Integer contact;
	private String email;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "property_id")
	private List<Property> properties;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "owner_id")
	private List<Owner> owners;

}
