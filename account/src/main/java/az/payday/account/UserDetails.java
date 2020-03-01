package az.payday.account;

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
		UserDetails.authorizationServiceInterface = authorizationServiceInterface;;
	}
	
	public static UserIDTO getUserIDTO() {
		HttpServletRequest request = 
		        ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes())
		                .getRequest();
		
		String token = request.getHeader("Authorization");
		
		return authorizationServiceInterface.getUser(token);
	}
}
