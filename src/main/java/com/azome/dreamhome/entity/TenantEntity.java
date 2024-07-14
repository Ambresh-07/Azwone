package com.azome.dreamhome.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Builder
public class TenantEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private Long contact;
	private String email;
	private String address;

	public static TenantEntity build(String name, Long contact, String email, String address) {
		return TenantEntity.
				builder()
				.name(name)
				.contact(contact)
				.email(email)
				.address(address)
				.build();
	}

}
