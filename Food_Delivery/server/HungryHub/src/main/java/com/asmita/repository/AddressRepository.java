package com.asmita.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asmita.model.Address;

public interface AddressRepository extends JpaRepository<Address,Long> {
	
}


