package az.payday.authorization.dto;

import java.time.Instant;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
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
	@Pattern(regexp="^\\S{6}$", message="Password must be alphanumeric and 6 characters")
	private String password;
	@Min(1)
	@Max(2)
	private Short gender;
	@NotNull
	@Past
	private Instant birthDate;
}
