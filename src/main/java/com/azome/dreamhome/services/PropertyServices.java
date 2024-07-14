package com.azome.dreamhome.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azome.dreamhome.entity.Property;
import com.azome.dreamhome.exceptions.UserNotFoundException;
import com.azome.dreamhome.repository.PropertyRepository;

@Service
public class PropertyServices {

	@Autowired
	PropertyRepository propertyRepository;

//	 create single property

	public Property createProperty(Property property) {
		return propertyRepository.save(property);
	}

//	create list of property
	public List<Property> createListProperty(List<Property> property) {
		return propertyRepository.saveAll(property);
	}

//get single property by id
	public Property getPropertyById(Long id) throws UserNotFoundException {
		return propertyRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("Property Id Not found : " + id));

	}

//	get all property
	public List<Property> getAllProperty() {
		return propertyRepository.findAll();
	}

//	delete  property by id
	public String deletePropertyById(Long id) throws UserNotFoundException {
		Property prop = propertyRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("property Id not Found in Database Id is:" + id));
//			
		propertyRepository.deleteById(prop.getId());
//		

		return "delete property by id is successfully...";
	}
//	delete all property

	public String deleteAllProperty() {
		propertyRepository.deleteAll();
		return "delete all property successfully...";
	}

	// update property by id

	public Property updatePropertyById(Property newdata, Long id) throws UserNotFoundException {
		Optional<Property> olddata = propertyRepository.findById(id);
//				.orElseThrow(()->new  UserNotFoundException("Property id Not found for updating record : " + id));
		Property property = null;
		if (olddata.isPresent()) {
			property = olddata.get();
			property.setName(newdata.getName());
			property.setAddress(newdata.getAddress());
			property.setConfigration(newdata.getConfigration());
			property.setFurnished(newdata.getFurnished());
			property.setPropertyAdds(newdata.getPropertyAdds());
			property.setRent_price(newdata.getRent_price());
			property.setSell_price(newdata.getSell_price());
			property.setTenant(newdata.getTenant());
			return propertyRepository.save(property);

		} else {
			throw new UserNotFoundException("Property id Not found for updating record : " + id);
		}

	}

}
