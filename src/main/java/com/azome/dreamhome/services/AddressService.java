package com.azome.dreamhome.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.azome.dreamhome.DTO.AddressRequest;
import com.azome.dreamhome.entity.Address;
import com.azome.dreamhome.exceptions.UserNotFoundException;
import com.azome.dreamhome.repository.AddressRepository;

@Service
public class AddressService {
	@Autowired
	AddressRepository addressRepository;

//	create single property
	public Address createAddress(AddressRequest addressRequest) {
		Address addressnew = Address.builder().landmark(addressRequest.getLandmark()).street(addressRequest.getStreet())
				.city(addressRequest.getCity()).pincode(addressRequest.getPincode()).build();

		return addressRepository.save(addressnew);
	}

//	create list of property
	public List<Address> createListAddress(List<Address> Address) {

		return addressRepository.saveAll(Address);
	}

//	get single property by id
	public Address getAddressById(Long id) throws UserNotFoundException {
		return addressRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("Address not found for this ID : " + id));

	}

	// get list of address
	public List<Address> getlistOfAddress() {
		return addressRepository.findAll();

	}

	// delete Address ById

	public String deleteAddressById(Long id) throws UserNotFoundException {
		addressRepository.findById(id).orElseThrow(() -> new UserNotFoundException("address is not found : " + id));
		return "Address Delete Succeefully done ...";

	}
	// deleteAll Address ById

	public String deleteAllAddress() {
		addressRepository.deleteAll();
		return "delete All Address successfully....";

	}

	// update Adress by Id

	public Address updateAddressById(Address address, Long id) throws UserNotFoundException {
		Optional<Address> olddata = addressRepository.findById(id);
		Address dbdata = null;

		if (olddata.isPresent()) {

			dbdata = olddata.get();
			dbdata.setLandmark(address.getLandmark());
			dbdata.setStreet(address.getStreet());
			dbdata.setCity(address.getCity());
			dbdata.setPincode(address.getPincode());

		} else {
			throw new UserNotFoundException("Address id not found for this id : " + id);

		}

		return addressRepository.save(dbdata);

	}

}
