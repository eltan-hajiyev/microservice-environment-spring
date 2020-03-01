package az.payday.authorization.dto;

import java.time.Instant;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class AuthorizationDTO {
	@NotBlank(message = "firstname can't be blank")
	private String firstName;
	@NotBlank(message = "lastname can't be blank")
	private String lastName;
	@NotBlank(message = "Phone can't be blank")
	private String phone;
	@Email(message = "Wrong email address")
	private String email;
	@NotBlank
	private String password;
	@Pattern(regexp = "{1|2}", message = "Gender can be 1 or 2")
	private Short gender;
	@NotBlank
	private Instant birthDate;
}
