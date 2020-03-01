package excludeautoscan.internal_service.intrface.a003;

import lombok.Data;

/**
 * @author Eltan Hajiyev
 *
 * User internal data transfer object
 */
@Data
public class UserIDTO {
	private Integer id;
	private String email;
	private String name;
	private String password;
}
