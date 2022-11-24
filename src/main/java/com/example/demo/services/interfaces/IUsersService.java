package com.example.demo.services.interfaces;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UsersDTO;

@Service
public interface IUsersService {
	
	List<UsersDTO> findAll(); //Se trae la informacion del DTO por buenas practicas
	
	UsersDTO findByUsername(String username);
	
	
	UsersDTO findByUserId(int userId);//aqui era userId
	
	void save(UserRequest user);
	void saveAll(List<UserRequest> users);//users
	void deleteById(int userId);

	

	
	
	

}
