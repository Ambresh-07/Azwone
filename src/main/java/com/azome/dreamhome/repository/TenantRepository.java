package com.azome.dreamhome.repository;

import java.lang.annotation.Native;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.azome.dreamhome.entity.Owner;
import com.azome.dreamhome.entity.TenantEntity;

import jakarta.persistence.NamedNativeQuery;

@Repository
public interface TenantRepository extends JpaRepository<TenantEntity, Long> {
	

//	 @Query(value="SELECT fname FROM owner WHERE id = (  SELECT property.owner_id FROM property WHERE property.tenant_id=( select tenant_entity.id from tenant_entity WHERE name=:n))")
//	public String findByName(@Param("n") String name);


}
