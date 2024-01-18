package com.evently.app.service;

import org.springframework.stereotype.Service;

import com.evently.app.model.Users;
import com.evently.app.repository.UsersRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class UsersService {
	private UsersRepository usersRepository;
	
	private void inscription (Users users) {
		
		this.usersRepository.save(users);
	}

}
