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
		
		if(!"123456".equals(code)) {return null;}
		
		// todo 调用校验列表校验登录数据
		Authentication authentication = new MyAuthentication(username, null, username, null, null, false);
		authentication = authenticationManager.authenticate(authentication);
		if(null == authentication) {
			return null;
		}
		// todo 校验成功后，通过tokenservice生成token
		return tokenServices.createAccessToken(new OAuth2Authentication(
				new OAuth2Request(null, "client", null, true, null, null, null, null, null), authentication));
	}


}
