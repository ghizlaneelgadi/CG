package com.axway.cg.services.Impl;

import com.axway.cg.ResourceNotFoundException;
import com.axway.cg.domain.User;
import com.axway.cg.repository.UserRepository;
import com.axway.cg.repository.UsersRepository;
import com.axway.cg.services.UsersService;

import javax.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UsersService{

	UsersRepository usersRepository;
	
	UserRepository userRepo;
	
	
	public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
	
	@Override
	public User getUserById(Long id) {
		return usersRepository.findById(id).get();
	}

	@Override
	public void updateUser(Long id, User user) {
		User userFromDb = usersRepository.findById(id).get();
		System.out.println(userFromDb.toString());
		userFromDb.setMail(user.getMail());
		usersRepository.save(userFromDb);
		
	}

	@Override
	public void deleteUser(Long id) {
		usersRepository.deleteById(id);	
	}

	@Override
	public boolean requestPasswordReset(String mail) {
		
		boolean returnValue = false;
		User user = userRepo.findByMail(mail);
		
		if(user == null) {
			return returnValue;
		}
		
		
		return returnValue;
	}
	
	
	

}
