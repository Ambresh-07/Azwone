package com.azome.dreamhome.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.azome.dreamhome.DTO.TenantRequest;
import com.azome.dreamhome.entity.Owner;
import com.azome.dreamhome.entity.TenantEntity;
import com.azome.dreamhome.exceptions.UserNotFoundException;
import com.azome.dreamhome.repository.TenantRepository;

@Service
public class TenantService {

	@Autowired
	TenantRepository tenantRepository;

//create tenant
	public TenantEntity createTenant(TenantRequest tenrequest) {
		TenantEntity tenent = TenantEntity.build(tenrequest.getName(), tenrequest.getContact(), tenrequest.getEmail(),
				tenrequest.getAddress());

		return tenantRepository.save(tenent);

	}

	// add list of tenant
	public List<TenantEntity> addListOfTenant(List<TenantEntity> tenant) {
		return tenantRepository.saveAll(tenant);
	}

	// get tenant by id
	public Optional<TenantEntity> getTenantById(@PathVariable Long id) throws UserNotFoundException {
		Optional<TenantEntity> optioTenent = tenantRepository.findById(id);
		TenantEntity tenData = null;
		if (optioTenent.isPresent()) {
			tenData = optioTenent.get();
			return tenantRepository.findById(tenData.getId());

		} else {
			throw new UserNotFoundException("tenant Id Not found : " + id);
		}

	}

	// get All tenant by

	public List<TenantEntity> getAllTenant() {
		return tenantRepository.findAll();

	}
	// delete tenant by

	public String deleteTenantById(@PathVariable Long id) throws UserNotFoundException {
		Optional<TenantEntity> optenant = tenantRepository.findById(id);

		if (optenant.isPresent()) {

			tenantRepository.deleteById(id);

			return "tenant deleted successfully...";

		} else {
			throw new UserNotFoundException("Tenant not fond in DB : " + id);
		}

	}
	// update tenant by id

	public TenantEntity updateTenantById(TenantEntity tenantEntity, Long id) {
		Optional<TenantEntity> optenant = tenantRepository.findById(id);
		TenantEntity dbData = null;

		if (optenant.isPresent()) {

			dbData = optenant.get();

			dbData.setName(tenantEntity.getName());
			dbData.setContact(tenantEntity.getContact());
			dbData.setEmail(tenantEntity.getEmail());
			dbData.setAddress(tenantEntity.getAddress());
			return tenantRepository.save(dbData);

		} else {
			throw new UserNotFoundException("Tenant not fond in DB : " + id);
		}

	}

	


}
