package com.ap_commerce.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class resetPasswordController {
	
	@Autowired
	private PasswordEncoder encoder;
	
	@GetMapping("/resetPassword")
	public String showFormResetPassword() {
		return "";
	}
}
