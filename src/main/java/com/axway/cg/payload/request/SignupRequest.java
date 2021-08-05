package com.axway.cg.payload.request;

import java.util.Set;
import javax.validation.constraints.*;

public class SignupRequest {
	 	@Size(min = 3, max = 20)
	    private String username;
	    
	    private Set<String> role;
	    
	    @NotBlank
	    @Size(min = 3, max = 40)
	    private String password;
	  
	    private String mail;
	    
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
	    
	    public Set<String> getRole() {
	      return this.role;
	    }
	    
	    public void setRole(Set<String> role) {
	      this.role = role;
	    }

		public String getMail() {
			return mail;
		}
		
		public void setMail(String mail) {
			this.mail = mail;
		}
}
