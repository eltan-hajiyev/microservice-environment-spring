package az.payday.authorization.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import az.payday.authorization.model.User;
import az.payday.authorization.model.config.UserStatus;
import az.payday.authorization.repository.UserRepository;
import excludeautoscan.internal_service.intrface.a002.MessageServiceInterface;

@Component
public class EmailForConfirmation {
	@Autowired
	UserRepository userRepository;

	@Autowired
	MessageServiceInterface messageServiceInterface;

	@Scheduled(fixedDelay = 5000)
	public void send() {
		List<User> userList = userRepository.findByStatus(UserStatus.WAITING_ACTIVATION.getValue());

		userList.stream().forEach(user -> {
			messageServiceInterface.sendMessage(user.getEmail(), "Please confirm mail");
		});
	}
}
