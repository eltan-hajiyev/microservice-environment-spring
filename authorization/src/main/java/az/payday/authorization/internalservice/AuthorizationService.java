package az.payday.authorization.internalservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import az.payday.authorization.model.User;
import az.payday.authorization.model.UserSession;
import az.payday.authorization.model.config.UserStatus;
import az.payday.authorization.repository.UserRepository;
import az.payday.authorization.repository.UserSessionRepository;
import excludeautoscan.internal_service.intrface.a003.AuthorizationServiceInterface;
import excludeautoscan.internal_service.intrface.a003.UserIDTO;

@RestController
public class AuthorizationService implements AuthorizationServiceInterface {
	@Autowired
	UserSessionRepository userSessionRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public Boolean checkToken(String token) {
		UserSession userSession = userSessionRepository.findByAuthKey(token);

		return userSession != null;
	}

	@Override
	public UserIDTO getUserByToken(String token) {
		UserSession userSession = userSessionRepository.findByAuthKey(token);

		UserIDTO userIDTO = new UserIDTO();
		userIDTO.setId(userSession.getUser().getId());
		userIDTO.setEmail(userSession.getUser().getEmail());
		userIDTO.setName(userSession.getUser().getFirstName());
		userIDTO.setName(userSession.getUser().getPassword());

		return userIDTO;
	}

	@Override
	public UserIDTO getUserByEmail(String email) {
		User user = userRepository.findByEmailAndStatus(email, UserStatus.ACTIVE.getValue());

		UserIDTO userIDTO = new UserIDTO();
		userIDTO.setId(user.getId());
		userIDTO.setEmail(user.getEmail());
		userIDTO.setName(user.getFirstName());
		userIDTO.setPassword(user.getPassword());

		return userIDTO;
	}

}
