package com.azome.dreamhome.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azome.dreamhome.DTO.AddressRequest;
import com.azome.dreamhome.entity.Address;
import com.azome.dreamhome.exceptions.UserNotFoundException;
import com.azome.dreamhome.services.AddressService;

@RestController
@RequestMapping("/Address")
public class AddressController {

	@Autowired
	AddressService addressService;

//	create single property
	@PostMapping
	public ResponseEntity<Address> createProperty(@RequestBody AddressRequest addressRequest) {
		return ResponseEntity.ok(addressService.createAddress(addressRequest));
	}

//	create list of property
	@PostMapping("/list")
	public ResponseEntity<List<Address>> createListAddress(@RequestBody List<Address> Address) {
		return ResponseEntity.ok(addressService.createListAddress(Address));
	}

//	get single property by id
	@GetMapping("/{id}")
	public ResponseEntity<Address> getAddressById(@PathVariable Long id) throws UserNotFoundException{
		return ResponseEntity.ok(addressService.getAddressById(id));

	}

//	get all address 
	@GetMapping("/list")
	public ResponseEntity<List<Address>> getListAddress() {
		return ResponseEntity.ok(addressService.getlistOfAddress());

	}

//	delete address by Id
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAddressById(@PathVariable Long id) throws  UserNotFoundException {
		return ResponseEntity.ok(addressService.deleteAddressById(id));

	}

//	delete All address 
	@DeleteMapping()
	public ResponseEntity<String> deleteAllAddressById() {
		return ResponseEntity.ok(addressService.deleteAllAddress());

	}

	// put mapping
	@PutMapping("/{id}")
	public ResponseEntity<Address> updateAddressById(@RequestBody Address address, @PathVariable Long id)throws UserNotFoundException  {
		return ResponseEntity.ok(addressService.updateAddressById(address, id));
	}

}
