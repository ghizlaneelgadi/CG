package com.axway.cg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axway.cg.domain.User;
import com.axway.cg.payload.request.PasswordResetRequestModel;
import com.axway.cg.payload.response.OperationStatusModel;
import com.axway.cg.repository.UsersRepository;
import com.axway.cg.services.UsersService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/userslist")
public class UsersController {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	UsersService usersService;
	
	@GetMapping
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List <User> getAllUsers() {
		return (List<User>) usersRepository.findAll();
	}
	
	@GetMapping({"/{id}"})
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(usersService.getUserById(id), HttpStatus.OK);
    }

	@PutMapping({"/{id}"})
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
		usersService.updateUser(id, user);
        return new ResponseEntity<>(usersService.getUserById(id), HttpStatus.OK);
    }
	
	@DeleteMapping({"/delete/{id}"})
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) {
		usersService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
	@PostMapping(path = "password-reset-request", 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public OperationStatusModel requestReset(@RequestBody PasswordResetRequestModel passwordRequestResetModel) {
		OperationStatusModel returnValue = new OperationStatusModel();
		boolean operationResult = usersService.requestPasswordReset(passwordRequestResetModel.getMail());
		returnValue.setOperationName(RequestOperationName.REQUEST_PASSWORD_RESET.name());
		returnValue.setOperationResult(RequestOperationStatus.ERROR.name());
		
		if(operationResult) {
			returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
		}
		
		return returnValue;
		
	}
	
}
