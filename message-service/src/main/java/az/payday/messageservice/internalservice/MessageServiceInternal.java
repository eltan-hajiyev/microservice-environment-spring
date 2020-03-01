package az.payday.messageservice.internalservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import az.payday.messageservice.model.Message;
import az.payday.messageservice.repository.MessageRepository;
import excludeautoscan.internal_service.intrface.a002.MessageServiceInterface;

@RestController
public class MessageServiceInternal implements MessageServiceInterface {
	@Autowired
	private MessageRepository messageRepository;

	@Override
	public Boolean sendMessage(String email, String text) {
		Message message = new Message();
		message.setEmail(email);
		message.setText(text);
		messageRepository.save(message);
		return true;
	}

}
