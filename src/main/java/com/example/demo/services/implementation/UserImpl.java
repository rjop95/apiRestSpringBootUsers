package com.example.demo.services.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UsersDTO;
import com.example.demo.entities.Users;
import com.example.demo.repository.UsersRepository;
import com.example.demo.services.interfaces.IUsersService;
import com.example.demo.utilities.BCrypt;
import com.example.demo.utilities.MHelpers;

@Component
public class UserImpl implements IUsersService {
	
	@Autowired
	private UsersRepository usersRepository;

	
	@Override
	public List<UsersDTO> findAll() {
		
		List<UsersDTO> dto = new ArrayList<>();
			
		Iterable<Users> users = this.usersRepository.findAll();	
		
		for(Users user : users) {
			UsersDTO usersDTO = MHelpers.modelMapper().map(user, UsersDTO.class);
			
			dto.add(usersDTO);
		}
		
		return dto;
		
		
	}

	@Override
	public UsersDTO findByUsername(String username) {
		
		Optional<Users> users = this.usersRepository.findByUsername(username);
				if(!users.isPresent() ) {
					return null;
				}
		return MHelpers.modelMapper().map(users.getClass(), UsersDTO.class);
	}

	@Override
	public UsersDTO findByUserId(int userId) {
		Optional<Users> users = this.usersRepository.findById(userId);
		if(!users.isPresent() ) {
			return null;
		}
			return MHelpers.modelMapper().map(users.getClass(), UsersDTO.class);
}
	

	@Override
	public void save(UserRequest user) {
		
		Users users = MHelpers.modelMapper().map(user, Users.class);
		
		users.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		
		this.usersRepository.save(users);
		
	}

	@Override
	public void saveAll(List<UserRequest> users) {
		
		List<Users> u = new ArrayList<>();
		
		for (UserRequest user : users) {
			
			Users us = MHelpers.modelMapper().map(user, Users.class);
			
			u.add(us);
		}
		
		this.usersRepository.saveAll(u);
		
	}

	@Override
	public void deleteById(int userId) {
	
		this.usersRepository.deleteById(userId);
		
	}
	
	
	public UsersDTO convertToUsersDTO(final Users users) {
		return MHelpers.modelMapper().map(users, UsersDTO.class);
	}

	

}
