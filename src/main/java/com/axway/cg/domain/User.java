package com.axway.cg.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "collaborateurs", uniqueConstraints = {@UniqueConstraint(columnNames = "username")})
public class User {

	@Id
	private String username;
	private String password;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable( name = "user_roles",
				joinColumns = @JoinColumn(name= "user_id"),
				inverseJoinColumns = @JoinColumn(name = "role_id")
			)
	private Set<Role> roles = new HashSet<>();
	
	public User() {
		
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	
	
	
	
	
	
	
	
}
