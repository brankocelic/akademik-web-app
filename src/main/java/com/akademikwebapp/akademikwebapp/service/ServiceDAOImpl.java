package com.akademikwebapp.akademikwebapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.akademikwebapp.akademikwebapp.entity.Jelo;
import com.akademikwebapp.akademikwebapp.entity.Users;
import com.akademikwebapp.akademikwebapp.repository.AuthoritiesRepository;
import com.akademikwebapp.akademikwebapp.repository.JelovnikRepository;
import com.akademikwebapp.akademikwebapp.repository.UsersRepository;

@Service
public class ServiceDAOImpl implements ServiceDAO {

	@Autowired
	private JelovnikRepository theRepositori;
	
	@Autowired
	private AuthoritiesRepository theAuthoritiesRepository;
	
	@Autowired
	private UsersRepository theUsersRepository;
	
	@Autowired
	private PasswordEncoder password;
	
	@Override
	public List<Jelo> findAll() {
		return theRepositori.findAll();
	}

	@Override
	public Jelo findById(int theId) {
		
		Optional<Jelo> result = theRepositori.findById(theId);

		Jelo theMeni = null;

		if (result == null) {
			throw new RuntimeException("Jelo sa id - " + theId + " nije pronadjeno");
		} else {
			theMeni = result.get();
		}

		return theMeni;
	}

	@Override
	public void save(Jelo theMeni) {
		
		theRepositori.save(theMeni);
		
	}

	@Override
	public void deleteById(int theId) {

		theRepositori.deleteById(theId);
		
	}

	@Override
	public void saveUser(Users theUsers) {
		
		String encodedPassword = password.encode(theUsers.getPassword());

		theUsers.setPassword(encodedPassword);
		
		theUsersRepository.save(theUsers);
		
		
	}

	@Override
	public List<Users> findaAll() {
		return theUsersRepository.findAll();
	}

	@Override
	public void deleteUser(String username) {
		
		theUsersRepository.deleteById(username);
		
	}

	@Override
	public void deleteAuthorityRole(int administratorRoleId) {
		
		theAuthoritiesRepository.deleteById(administratorRoleId);
		
	}

	@Override
	public Users findUserById(String userId) {
		
		Optional<Users> user = theUsersRepository.findById(userId);
		
		return user.get();
	}

	@Override
	public void deleteAllById(String username) {
		//theAuthoritiesRepository.
	}

}
