package az.payday.authorization.dto;

import java.time.Instant;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class AuthorizationDTO {
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@NotBlank
	private String phone;
	@Email
	private String email;
	@NotBlank
	private String password;
	@Pattern(regexp = "{1|2}", message = "Gender can be 1 or 2")
	private Short gender;
	@NotBlank
	private Instant birthDate;
}
