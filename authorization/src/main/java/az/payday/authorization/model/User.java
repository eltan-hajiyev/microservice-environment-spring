package az.payday.authorization.model;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Entity
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String firstName;
	private String lastName;
	private String phone;

	@Column(unique = true, length = 50)
	private String email;

	@Column(length = 60)
	private String password;
	private String salt;
	private Short gender;
	private Instant birthDate;

	@Setter(AccessLevel.NONE)
	private Instant insertDate = Instant.now();
	private Short status;
	
}
