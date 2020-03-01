package az.payday.account.model;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Entity
public class Transaction implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String token;
	private Integer idAccount;
	
	@Setter(AccessLevel.NONE)
	private Instant insertDate = Instant.now();
}
