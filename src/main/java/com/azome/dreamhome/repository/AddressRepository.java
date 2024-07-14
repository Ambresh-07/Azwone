package com.azome.dreamhome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azome.dreamhome.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
