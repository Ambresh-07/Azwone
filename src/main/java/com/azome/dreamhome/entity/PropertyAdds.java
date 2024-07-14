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
public class PropertyAdds {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String title;
	private String summary;
	private double rental_amont;
	private double sell_price;
	private String add_type;
	private String owner;
	private String propertyage;
	private double deposite;
	
	public static PropertyAdds build(String title, String summary, double rental_amont, double sell_price,
			String add_type, String owner, String propertyage, double deposite) {
		return PropertyAdds.builder()
				.title(title)
				.summary(summary)
				.rental_amont(rental_amont)
				.sell_price(sell_price)
				.add_type(add_type)
				.owner(owner)
				.propertyage(propertyage)
				.deposite(deposite)
				.build();
				
				
	}
	

	
	
	




	
	

}
