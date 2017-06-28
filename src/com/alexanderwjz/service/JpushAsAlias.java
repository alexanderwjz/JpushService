package com.alexanderwjz.service;

import javax.jws.WebService;
@WebService
public interface JpushAsAlias {
	public void push(String usernameAsalias, String UserDefinedMessage);
}
