package com.azome.dreamhome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azome.dreamhome.entity.Property;
@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

}
