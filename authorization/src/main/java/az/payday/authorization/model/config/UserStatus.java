package az.payday.authorization.model.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum UserStatus {
	WAITING_ACTIVATION((short) 2), //
	ACTIVE((short) 1), //
	DISABLED((short) 0); //

	@Getter
	private Short value;
}
