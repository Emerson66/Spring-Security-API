package com.buritiscript.springSecurityAPI.domain.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority {

	private static final long serialVersionUID = 1L;
	public static final String USER_ADMIN = "USER_ADMIN";
	public static final String AUTHOR_ADMIN = "AUTHOR_ADMIN";
	public static final String BOOK_ADMIN = "BOOK_ADMIN";

	private String authority;

    private Set<Role> authorities = new HashSet<>();

	
	public Role() {
	}

	public Role(String authority) {
		super();
		this.authority = authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return null;
	}

}
