package com.azome.dreamhome.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azome.dreamhome.DTO.BrokerRequest;
import com.azome.dreamhome.entity.Broker;
import com.azome.dreamhome.exceptions.UserNotFoundException;
import com.azome.dreamhome.repository.BrokerRepository;

@Service
public class BrokerService {

	@Autowired
	BrokerRepository brokerRepository;

	// create brokers
	public Broker createBroker(Broker broker) {
		
//		Broker broker = Broker.builder()
//				.name(brokerRequest.getName())
//				.contact(brokerRequest.getContact())
//				.email(brokerRequest.getEmail())
//				.build();

		return brokerRepository.save(broker);
	}

//find all brokers
	public List<Broker> getAllBrokers() {
		return brokerRepository.findAll();
	}

	// get broker by id

	public Broker getBrokerById(Long id) {

		return brokerRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("Broker for this id Not found : " + id));
	}

	// delete Broker by id

	public String deleteBrokerById(Long id) throws UserNotFoundException {

		Broker broker = brokerRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("Broker for this id Not found : " + id));
//		just for debugging
		System.out.println(" return the findout data for delete : " + broker.getId());

		brokerRepository.deleteById(broker.getId());

		return "delete broker successfully...";

	}

	// update Broker By id

	public Broker updateBrokerById(Broker broker, Long id) throws UserNotFoundException{
		Optional<Broker> broke = brokerRepository.findById(id);

		Broker DBdata = null;
		
		if (broke.isPresent()) {
			DBdata = broke.get();
			DBdata.setName(broker.getName());
			DBdata.setContact(broker.getContact());
			DBdata.setEmail(broker.getEmail());
			DBdata.setProperties(broker.getProperties());
			DBdata.setOwners(broker.getOwners());
			
			return brokerRepository.save(DBdata);

		}else {
			throw new UserNotFoundException(" Broker Id Not found in DB : "+id);
			
		}

	}

}
