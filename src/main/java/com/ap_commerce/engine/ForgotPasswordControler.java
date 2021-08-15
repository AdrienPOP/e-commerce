package com.ap_commerce.engine;

import java.security.SecureRandom;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ap_commerce.engine.authentication.exceptions.UserDoesNotExistException;
import com.ap_commerce.engine.entities.Category;
import com.ap_commerce.engine.entities.User;
import com.ap_commerce.engine.repositories.CategoryRepository;
import com.ap_commerce.engine.repositories.UserRepository;

@Controller
public class ForgotPasswordControler {
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
    private JavaMailSender emailSender;
	
	@GetMapping("/forgotPassword")
	public String showFormForgotPassword(Model model, @ModelAttribute User user) {
		List <Category> categories = categoryRepository.findAll();
		model.addAttribute("categories",categories);
		return "forgotPassword";
	}
	@PostMapping("/forgotPassword")
	public @ResponseBody String sendMailForResetPassword(@ModelAttribute User user, SimpleMailMessage message, SecureRandom secureRandom) throws UserDoesNotExistException {
		
		if(userRepository.findByEmail(user.getEmail()).isPresent()) {
			byte bytes[] = new byte[20];
			secureRandom.nextBytes(bytes);
			String token = bytes.toString();
			
			user = userRepository.findByEmail(user.getEmail()).get();
			message.setTo(user.getEmail());
			message.setSubject("Lien de modification de mot de passe Ap-Shop !");
			message.setText("Bonjour, veuillez trouver le lien pour modifier le mot de passe : \n http://localhost:8080/engine/resetPassword?idUser=" + user.getId() + "&token=" );
			this.emailSender.send(message);
			return "Mail envoyé";
		} else {
			throw new UserDoesNotExistException("L'adresse mail n'est pas correct");
		}        
	}

}
