package az.payday.messageservice.model.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum MessageStatus {
	INITIAL((short) 4), //
	START((short) 3), //
	SUCCESS((short) 1);

	@Getter
	private Short value;
}
