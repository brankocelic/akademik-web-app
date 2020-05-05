package com.akademikwebapp.akademikwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akademikwebapp.akademikwebapp.entity.Users;

public interface UsersRepository extends JpaRepository<Users, String> {

}
