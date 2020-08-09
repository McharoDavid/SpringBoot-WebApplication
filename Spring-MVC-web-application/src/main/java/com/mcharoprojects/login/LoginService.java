package com.mcharoprojects.login;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public boolean isUserValid(String user, String password) {
		if(user.equals("David Mcharo") && password.equals("David1993"))
			return true;
		return false;
	}

}
