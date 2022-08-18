package com.spring.service;

import java.sql.SQLException;

import com.spring.exception.InvalidPasswordException;
import com.spring.exception.NotFoundIdException;

public interface LoginSearchMemberService extends MemberService {

	void login(String id, String pwd) throws NotFoundIdException, InvalidPasswordException, SQLException;

}