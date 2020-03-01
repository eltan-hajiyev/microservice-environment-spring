package az.payday.authorization.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.payday.authorization.UserDetails;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/")
public class AuthorizationController {

	@ApiOperation("Just for test")
	@PostMapping("/login-test")
	public Boolean loginTest() {
		return true;
	}

	@ApiOperation("Just for test")
	@PostMapping("/test-user-access")
	public String checkUserAccessFromMicroservice() {
		return UserDetails.getUserIDTO().getEmail();
	}
}
