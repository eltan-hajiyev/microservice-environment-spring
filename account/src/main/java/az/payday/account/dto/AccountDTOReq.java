package az.payday.account.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Data;

@Data
public class AccountDTOReq {
	@Min(value=1, message = "Card type must be 1 or 2")
	@Max(value=2, message = "Card type must be 1 or 2")
	private Short accountType;
}
