package com.axway.cg.services;


import com.axway.cg.domain.User;


public interface UsersService {

    void updateUser(Long id, User user);

    void deleteUser(Long id);

	User getUserById(Long id);

	boolean requestPasswordReset(String mail);
	
	
}
