package com.example.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.ContactEntity;

public interface ContactDtlsRepository extends 
                       JpaRepository<ContactEntity, Serializable> {

	
}
