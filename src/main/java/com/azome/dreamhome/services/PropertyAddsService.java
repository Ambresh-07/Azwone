package com.azome.dreamhome.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azome.dreamhome.DTO.PropertyAddsRequest;
import com.azome.dreamhome.entity.PropertyAdds;
import com.azome.dreamhome.exceptions.UserNotFoundException;
import com.azome.dreamhome.repository.PropertyAddsRepository;

@Service
public class PropertyAddsService {

	@Autowired
	PropertyAddsRepository propertyAddsRepository;

	// create adds

	public PropertyAdds createAdd(PropertyAddsRequest propAddRequest) {

		PropertyAdds props = PropertyAdds.build(

				propAddRequest.getTitle(), propAddRequest.getSummary(), propAddRequest.getRental_amont(),
				propAddRequest.getSell_price(), propAddRequest.getAdd_type(), propAddRequest.getOwner(),
				propAddRequest.getPropertyage(), propAddRequest.getDeposite()

		);

		return propertyAddsRepository.save(props);

	}

	// return single of adds by id
	public PropertyAdds getAddsById(Long id)  {

		return propertyAddsRepository.findById(id).orElseThrow(()->new UserNotFoundException("Addvertisement Id Not found in DB :  " + id));
	

	}

	// get All adds
	public List<PropertyAdds> getListOfAdds() {
		return propertyAddsRepository.findAll();

	}

//	delete adds Bt Id
	public String deleteAddsById(Long id) {
		propertyAddsRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("AdertisementId Not found :" + id));

		propertyAddsRepository.deleteById(id);
		return "delete Addvertisement successfully...";
	}

	// update advertisement

	public PropertyAdds updateAddvertisement(PropertyAdds adds, Long id) throws UserNotFoundException {
		Optional<PropertyAdds> oldAdvetise = propertyAddsRepository.findById(id);
		PropertyAdds DbData = null;
		if (oldAdvetise.isPresent()) {

			DbData = oldAdvetise.get();

			DbData.setTitle(adds.getTitle());

			DbData.setSummary(adds.getSummary());

			DbData.setRental_amont(adds.getRental_amont());

			DbData.setSell_price(adds.getSell_price());

			DbData.setAdd_type(adds.getAdd_type());

			DbData.setPropertyage(adds.getPropertyage());

			DbData.setOwner(adds.getOwner());

			DbData.setDeposite(adds.getDeposite());
			return propertyAddsRepository.save(DbData);

		} else {
			throw new UserNotFoundException("Advertisement for this Id is not found : " + id);
		}

	}

}
