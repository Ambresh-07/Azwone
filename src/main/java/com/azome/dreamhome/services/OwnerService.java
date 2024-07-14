package com.azome.dreamhome.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.azome.dreamhome.entity.Owner;
import com.azome.dreamhome.exceptions.UserNotFoundException;
import com.azome.dreamhome.repository.OwnerRepository;

@Service
public class OwnerService {

	@Autowired
	OwnerRepository ownerRepository;

//create owner
	public Owner createOwner(Owner owner) {
		return ownerRepository.save(owner);

	}

	// create list of owner

	public List<Owner> getallOwner() {
		return ownerRepository.findAll();
	}

	// get owner

	public Optional<Owner> getOwnerById(Long id) throws UserNotFoundException {
		ownerRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("Owner Not Found For this Id : " + id));
		return ownerRepository.findById(id);
	}

	// delete owner byId
	public String deleteOwnerById(Long id) throws UserNotFoundException {
		ownerRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("Owner Not Found For this Id : " + id));
		ownerRepository.deleteById(id);
		return "delete owner successfully...";
	}

	// update owner
	public Owner updateOwnerById(Owner owner, Long id) throws UserNotFoundException{

		Optional<Owner> olddata = ownerRepository.findById(id);
		Owner onwer = null;
		if (olddata.isPresent()) {
			onwer = olddata.get();
			onwer.setFname(owner.getFname());
			onwer.setLname(owner.getLname());
			owner.setProperty(owner.getProperty());

		}else {
			throw new UserNotFoundException("owner Id is not found : "+id);
		}

		return ownerRepository.save(onwer);
	}

}
