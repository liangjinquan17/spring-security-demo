package com.sf.springsecurity.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.TokenGranter;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;

public class MyTokenGranter implements TokenGranter{
	
	private String grantType = "verificationCode";
	
	private AuthenticationManager authenticationManager;
	private AuthorizationServerTokenServices tokenServices;
	
	public MyTokenGranter(AuthenticationManager authenticationManager, AuthorizationServerTokenServices tokenServices) {
		this.authenticationManager = authenticationManager;
		this.tokenServices = tokenServices;
	}

	@SuppressWarnings("deprecation")
	@Override
	public OAuth2AccessToken grant(String grantType, TokenRequest tokenRequest) {
		if(!this.grantType.equals(grantType)) {
			return null;
		}
		
		Map<String, String> parameters = new LinkedHashMap<String, String>(tokenRequest.getRequestParameters());
		String username = parameters.get("username");
		String code = parameters.get("code");
		System.out.println("username:"+username+"  code:"+code);
		
		Authentication authentication = new MyAuthentication("username", null, null, null, null, false);
//		authentication = authenticationManager.authenticate(authentication);
		
		return tokenServices.createAccessToken(new OAuth2Authentication(new OAuth2Request(null, "123", null, true, null, null, null, null, null), authentication));
	}

//	protected MyTokenGranter(AuthorizationServerTokenServices tokenServices, ClientDetailsService clientDetailsService,
//			OAuth2RequestFactory requestFactory, String grantType) {
//		super(tokenServices, clientDetailsService, requestFactory, grantType);
//		// TODO Auto-generated constructor stub
//	}

}
