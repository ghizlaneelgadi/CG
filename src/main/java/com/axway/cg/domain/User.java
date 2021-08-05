package com.axway.cg.domain;

import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

import javax.persistence.*;

@Entity
@Table(name = "collaborateurs", uniqueConstraints = {@UniqueConstraint(columnNames = "username"), @UniqueConstraint(columnNames = "mail")})
public class User {

	@Id
	@Column( name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 20)
	private String username;
	
	@NotBlank
	@Size(max = 120)
	private String password;
	
	@NotBlank
	@Size(max = 200)
	private String mail;
	
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable( name = "user_roles",
				joinColumns = @JoinColumn(name= "user_id", referencedColumnName="id"),
				inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName="Id")
			)
	private Set<Role> roles = new HashSet<>();
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	

	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}

	
	

	public User(String username, String mail, String password) {
		this.username = username;
		this.mail = mail;
		this.password = password;	
	}

	public User() {
		
	}

	
}
