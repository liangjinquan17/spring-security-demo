package com.sf.springsecurity.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class MyAuthentication implements Authentication {
	
	private static final long serialVersionUID = -9095353071305602273L;
	
	public MyAuthentication(String name, List<GrantedAuthority> authenrities, Object credentials, Object details, Object principal, boolean isAuthenticated) {
		this.name = name;
		this.authenrities = authenrities;
		this.credentials = credentials;
		this.details = details;
		this.principal = principal;
		this.isAuthenticated = isAuthenticated;
	}
	
	private String name;
	private List<GrantedAuthority> authenrities;
	private Object credentials;
	private Object details;
	private Object principal;
	private boolean isAuthenticated = false;
	

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authenrities;
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return credentials;
	}

	@Override
	public Object getDetails() {
		// TODO Auto-generated method stub
		return details;
	}

	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return principal;
	}

	@Override
	public boolean isAuthenticated() {
		// TODO Auto-generated method stub
		return isAuthenticated;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		this.isAuthenticated = isAuthenticated;
	}

}
