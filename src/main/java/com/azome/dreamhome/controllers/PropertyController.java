package com.azome.dreamhome.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azome.dreamhome.entity.Property;
import com.azome.dreamhome.exceptions.UserNotFoundException;
import com.azome.dreamhome.services.PropertyServices;

@RestController
@RequestMapping("/property")
public class PropertyController {

	@Autowired
	PropertyServices propertyServices;

//	create single property
	@PostMapping
	public ResponseEntity<Property> createProperty(@RequestBody Property prop) {
		return new ResponseEntity<Property>(propertyServices.createProperty(prop), HttpStatus.CREATED);
	}

//	create list of property
	@PostMapping("/list")
	public ResponseEntity<List<Property>> createListProperty(@RequestBody List<Property> prop) {
		return new ResponseEntity<List<Property>>(propertyServices.createListProperty(prop), HttpStatus.CREATED);
	}

//	get single property by id
	@GetMapping("/{id}")
	public ResponseEntity<Property> getPropertyById(@PathVariable Long id) throws UserNotFoundException{
		return ResponseEntity.ok(propertyServices.getPropertyById(id));

	}

//	get list of or all property 
	@GetMapping("/list")
	public List<Property> getAllProperty() {
		return propertyServices.getAllProperty();
	}

	// delete property
	@DeleteMapping("/{id}")
	public String deletePropertyById(@PathVariable Long id)  throws UserNotFoundException{
		
		return propertyServices.deletePropertyById(id);
	}

	// delete All property
	@DeleteMapping()
	public String deleteAllProperty() {
		return propertyServices.deleteAllProperty();
	}

	// update property

	@PutMapping("/{id}")
	public Property updatePropertyById(@RequestBody Property prop, @PathVariable Long id) throws UserNotFoundException {

		return propertyServices.updatePropertyById(prop, id);
	}

}
