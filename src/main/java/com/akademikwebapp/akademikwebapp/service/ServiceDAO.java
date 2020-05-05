package com.akademikwebapp.akademikwebapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.akademikwebapp.akademikwebapp.entity.Jelo;
import com.akademikwebapp.akademikwebapp.entity.Users;

@Service
public interface ServiceDAO {
	
	public List<Jelo> findAll();
	
	public Jelo findById(int theId);
	
	public void save(Jelo theMeni);
	
	public void deleteById(int theId);

	public void saveUser(Users theUsers);
	
	public List<Users> findaAll();
	
	public void deleteUser(String username);
	
	public void deleteAuthorityRole(int administratorRoleId);

	public Users findUserById(String userId);
	
	public void deleteAllById(String username);
}
