package az.payday.account.model.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum AccountType {
	DEBIT((short) 1), //
	DEPOSIT((short) 2);

	@Getter
	private Short value;
}
