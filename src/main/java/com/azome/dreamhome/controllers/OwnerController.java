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

import com.azome.dreamhome.entity.Owner;
import com.azome.dreamhome.exceptions.UserNotFoundException;
import com.azome.dreamhome.services.OwnerService;

@RestController
@RequestMapping("/owner")
public class OwnerController {

	@Autowired
	OwnerService ownerService;

//create single owner
	@PostMapping()
	public ResponseEntity<Owner> createOwner(@RequestBody Owner owner) {
		return ResponseEntity.ok(ownerService.createOwner(owner));

	}

//get owner list
	@GetMapping("/list")
	public ResponseEntity<List<Owner>> getAllOwner() {
		return ResponseEntity.ok(ownerService.getallOwner());
	}

	// get owner
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Owner>> getOwnerById(@PathVariable Long id) throws UserNotFoundException {
		return ResponseEntity.ok(ownerService.getOwnerById(id));
	}

	// delete owner by id
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOwnerById(@PathVariable Long id) throws UserNotFoundException {
		return ResponseEntity.ok(ownerService.deleteOwnerById(id));
	}

	// update owner
	@PutMapping("/{id}")

	public ResponseEntity<Owner> updateownerById(@RequestBody Owner owner, @PathVariable Long id)
			throws UserNotFoundException {

		return ResponseEntity.ok(ownerService.updateOwnerById(owner, id));
	}

}
