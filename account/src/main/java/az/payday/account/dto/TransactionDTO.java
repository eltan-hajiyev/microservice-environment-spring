package az.payday.account.dto;

import lombok.Data;

@Data
public class TransactionDTO {
	private Integer idAccount;
	private String token;
	private Integer amount;
}
