package az.payday.zuulgateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() //
				.antMatchers(HttpMethod.GET, "/*/actuator/health").permitAll() //
				.antMatchers("/*/internal/**").denyAll() //
				.antMatchers("/*/v2/api-docs").permitAll() //
				.antMatchers("/*/public/**").permitAll() //
				.anyRequest().authenticated();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/v2/api-docs/**", //
				"/configuration/ui/**", //
				"/swagger-resources/**", //
				"/configuration/security/**", //
				"/swagger-ui.html", //
				"/webjars/**");
	}

}
