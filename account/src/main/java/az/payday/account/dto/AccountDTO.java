package az.payday.account.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class AccountDTO {
	@NotNull
	private Integer idUser;

	@Pattern(regexp = "{1|2}", message = "Card type must be 1 or 2")
	private Short accountType;
}
