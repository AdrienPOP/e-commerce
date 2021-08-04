package com.ap_commerce.engine.authentication.exceptions;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ap_commerce.engine.entities.User;
import com.ap_commerce.engine.repositories.UserRepository;

@Controller
public class UserCrudController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/registerUser")
	public @ResponseBody User register(@ModelAttribute User user) throws UserAlreadyExistException{
		
		if (emailAlreadyExist(user.getEmail())) {
			throw new UserAlreadyExistException("Un compte utilisant cet email existe déjà !");
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("USER");
		return userRepository.save(user);
	}
	
	private boolean emailAlreadyExist(String email) {
		Optional<User> user = userRepository.findByEmail(email);
		return user.isPresent();
	}
}

