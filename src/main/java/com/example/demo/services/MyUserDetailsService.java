package com.example.demo.services;

import com.example.demo.models.UserModel;
import com.example.demo.config.UserPrinciples;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository urepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserModel user = urepo.findUserBy_id(username);

		if(user == null) {
			throw new UsernameNotFoundException(username);
		}

		return new UserPrinciples(user);

	}



}
