package com.alexanderwjz.service;

import javax.jws.WebService;

@WebService
public interface Jpush {
	public void pushAllNotice(String notice);
	public void pushAsAliasUdM(String usernameAsalias, String UserDefinedMessage);
	
}
