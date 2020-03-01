package az.payday.authorization.controller;

import java.util.Base64;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.payday.authorization.dto.AuthorizationDTO;
import az.payday.authorization.model.User;
import az.payday.authorization.model.config.UserStatus;
import az.payday.authorization.repository.UserRepository;

@RestController
@RequestMapping("/public")
public class PublicController {
	@Autowired
	UserRepository userRepository;
	
	BCryptPasswordEncoder cryptPasswordEncoder = new BCryptPasswordEncoder();

	@PostMapping("/create")
	public void create(@Valid @RequestBody AuthorizationDTO authorizationDTO) {
		User user = new User();
		user.setEmail(authorizationDTO.getEmail());
		user.setFirstName(authorizationDTO.getFirstName());
		user.setLastName(authorizationDTO.getLastName());
		user.setBirthDate(authorizationDTO.getBirthDate());
		user.setGender(authorizationDTO.getGender());
		user.setPhone(authorizationDTO.getPhone());
		user.setPassword(cryptPasswordEncoder.encode(authorizationDTO.getPassword()));
		user.setStatus(UserStatus.WAITING_ACTIVATION.getValue());

		userRepository.save(user);
	}
	
	/**
	 * 
	 * @param emailConfirmKey
	 * 
	 * I know it's wrong. But it just for test now.
	 */
	@GetMapping("/{emailConfirmKey}")
	public void emailConfirm(@PathVariable("emailConfirmKey") String emailConfirmKey) {
		String email = new String(Base64.getDecoder().decode(emailConfirmKey));
		User user = userRepository.findByEmail(email);
		user.setStatus(UserStatus.ACTIVE.getValue());
		userRepository.save(user);
	}
}
