package az.payday.authorization;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import excludeautoscan.internal_service.intrface.a003.AuthorizationServiceInterface;
import excludeautoscan.internal_service.intrface.a003.UserIDTO;

@Component
public class UserDetails {

	private static AuthorizationServiceInterface authorizationServiceInterface;

	@Autowired
	public UserDetails(AuthorizationServiceInterface authorizationServiceInterface) {
		UserDetails.authorizationServiceInterface = authorizationServiceInterface;
	}

	public static UserIDTO getUserIDTO() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();

		String token = request.getHeader("Authorization").split(" ")[1];
		String email = new String(Base64.getDecoder().decode(token.getBytes())).split(":")[0];

		return authorizationServiceInterface.getUserByEmail(email);
	}
}
