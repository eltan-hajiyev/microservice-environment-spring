package az.payday.messageservice.task;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import az.payday.messageservice.model.Message;
import az.payday.messageservice.model.config.MessageStatus;
import az.payday.messageservice.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SendMailTask {
	@Autowired
	private MessageRepository messageRepository;

	@Scheduled(fixedDelay = 5000)
	public void senEmail() {
		log.debug("mail send started");
		Instant date = Instant.now().minus(4, ChronoUnit.MINUTES);

		List<Message> messageList = messageRepository
				.findByStatusAndInsertDateGreaterThan(MessageStatus.INITIAL.getValue(), date);

		for (Message message : messageList) {
			sendEamil(message);
		}
		log.debug("mail send end");
	}

	private void sendEamil(Message message) {
		System.out.println("message send: " + message.getEmail() + ": " + message.getText());
		message.setStatus(MessageStatus.SUCCESS.getValue());
		messageRepository.save(message);
	}
}
