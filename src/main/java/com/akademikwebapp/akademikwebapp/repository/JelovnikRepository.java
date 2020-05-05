package com.akademikwebapp.akademikwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akademikwebapp.akademikwebapp.entity.Jelo;

public interface JelovnikRepository extends JpaRepository<Jelo, Integer> {
	
}
