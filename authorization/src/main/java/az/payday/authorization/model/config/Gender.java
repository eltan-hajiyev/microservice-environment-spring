package az.payday.authorization.model.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Gender {
	MAN((short) 1), //
	WOMAN((short) 2);

	@Getter
	private Short value;
}
