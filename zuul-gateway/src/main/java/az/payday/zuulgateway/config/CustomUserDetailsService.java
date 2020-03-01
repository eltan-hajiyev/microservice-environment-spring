package az.payday.zuulgateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import excludeautoscan.internal_service.intrface.a003.AuthorizationServiceInterface;
import excludeautoscan.internal_service.intrface.a003.UserIDTO;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	AuthorizationServiceInterface authorizationServiceInterface;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserIDTO user = authorizationServiceInterface.getUserByEmail(username);

		if (user == null) {
			throw new UsernameNotFoundException(username);
		}

		return new MyUserPrincipal(user);
	}

}
