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

import com.azome.dreamhome.DTO.TenantRequest;
import com.azome.dreamhome.entity.Owner;
import com.azome.dreamhome.entity.TenantEntity;
import com.azome.dreamhome.exceptions.UserNotFoundException;
import com.azome.dreamhome.services.TenantService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tenant")
public class TenantNewController {
	@Autowired
	TenantService tenantService;

	// create tenant

	@PostMapping()
	public ResponseEntity<TenantEntity> createTenant(@Valid @RequestBody TenantRequest tenant) {
		return new ResponseEntity<TenantEntity>(tenantService.createTenant(tenant), HttpStatus.CREATED);
	}

	// create list of tenant
	@PostMapping("/list")
	public ResponseEntity<List<TenantEntity>> createListOfTenant(@RequestBody List<TenantEntity> litenant) {
		return new ResponseEntity<List<TenantEntity>>(tenantService.addListOfTenant(litenant), HttpStatus.CREATED);
	}

	// get tenant by id
	@GetMapping("/{id}")
	public ResponseEntity<Optional<TenantEntity>> getTenantById(@PathVariable Long id) throws UserNotFoundException {
		return new ResponseEntity<Optional<TenantEntity>>(tenantService.getTenantById(id), HttpStatus.FOUND);
	}
	// get All tenant by

	@GetMapping("/list")
	public ResponseEntity<List<TenantEntity>> getAllTenant() {
		return ResponseEntity.ok(tenantService.getAllTenant());
	}
	// delete tenant by id

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTenantById(@PathVariable Long id) throws UserNotFoundException {
		return new ResponseEntity<String>(tenantService.deleteTenantById(id), HttpStatus.OK);
	}

	// update tenant by id

	@PutMapping("/{id}")
	public ResponseEntity<TenantEntity> updateUserById(@RequestBody TenantEntity tenantEntity, @PathVariable Long id) {

		return new ResponseEntity<TenantEntity>(tenantService.updateTenantById(tenantEntity, id), HttpStatus.CREATED);

	}



}
