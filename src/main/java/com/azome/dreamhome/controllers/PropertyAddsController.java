package com.azome.dreamhome.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azome.dreamhome.DTO.PropertyAddsRequest;
import com.azome.dreamhome.entity.PropertyAdds;
import com.azome.dreamhome.exceptions.UserNotFoundException;
import com.azome.dreamhome.services.PropertyAddsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/addvertisement")
public class PropertyAddsController {

	@Autowired
	PropertyAddsService propertyAddsService;

//	create advertisement
	@PostMapping()
	public ResponseEntity<PropertyAdds> createAdd(@Valid @RequestBody PropertyAddsRequest addverRequest) {
		return ResponseEntity.ok(propertyAddsService.createAdd(addverRequest));

	}

	// get list of advertisement
	@GetMapping("/list")
	public ResponseEntity<List<PropertyAdds>> getAllAddvertisement() {
		return ResponseEntity.ok(propertyAddsService.getListOfAdds());

	}

//	get advertisement ById

	@GetMapping("/{id}")
	public PropertyAdds getAddById(@PathVariable Long id) {
		return propertyAddsService.getAddsById(id);

	}

	// delete advertisement by Id

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAddvertiseById(@PathVariable Long id) {
		return ResponseEntity.ok(propertyAddsService.deleteAddsById(id));
	}

	// update advertisement by id
	@PutMapping("/{id}")
	public ResponseEntity<PropertyAdds> updatePropertyAddvertisement(@RequestBody PropertyAdds propsAdds,
			@PathVariable Long id) {
		return new ResponseEntity<PropertyAdds>(propertyAddsService.updateAddvertisement(propsAdds, id),
				HttpStatus.CREATED);
	}

}
