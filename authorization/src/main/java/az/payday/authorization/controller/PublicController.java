package az.payday.authorization.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import az.payday.authorization.dto.AuthorizationDTO;
import az.payday.authorization.model.User;
import az.payday.authorization.model.config.UserStatus;
import az.payday.authorization.repository.UserRepository;

@RestController("/public")
public class PublicController {
	@Autowired
	UserRepository userRepository;

	@PostMapping("/create")
	public void create(@Valid AuthorizationDTO authorizationDTO) {
		User user = new User();
		user.setEmail(authorizationDTO.getEmail());
		user.setFirstName(authorizationDTO.getFirstName());
		user.setLastName(authorizationDTO.getLastName());
		user.setBirthDate(authorizationDTO.getBirthDate());
		user.setGender(authorizationDTO.getGender());
		user.setPhone(authorizationDTO.getPhone());
		user.setStatus(UserStatus.WAITING_ACTIVATION.getValue());

		userRepository.save(user);
	}
}
