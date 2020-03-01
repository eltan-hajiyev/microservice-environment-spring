package az.payday.authorization.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/")
public class AuthorizationController {

	@ApiOperation("Just for testing")
	@PostMapping("/login-test")
	public Boolean loginTest() {
		return true;
	}
}
