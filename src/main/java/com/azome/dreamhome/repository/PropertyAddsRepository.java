package com.azome.dreamhome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azome.dreamhome.entity.PropertyAdds;

@Repository
public interface PropertyAddsRepository  extends JpaRepository<PropertyAdds, Long>{

}