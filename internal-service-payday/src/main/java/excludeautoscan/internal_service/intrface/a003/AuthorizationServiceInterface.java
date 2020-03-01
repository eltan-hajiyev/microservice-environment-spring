package excludeautoscan.internal_service.intrface.a003;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import excludeautoscan.internal_service.InternalService;
import excludeautoscan.internal_service.MicroServiceName;


@InternalService(MicroServiceName.AUTHORIZATION + MicroServiceName.GROUP)
@FeignClient(MicroServiceName.AUTHORIZATION)
public interface AuthorizationServiceInterface {
	@GetMapping("/check-token")
	Boolean checkToken(@RequestParam("token") String token);

	@GetMapping("/get-user-bytoken")
	UserIDTO getUserByToken(@RequestParam("token") String token);
	
	@GetMapping("/get-user-byemail")
	UserIDTO getUserByEmail(@RequestParam("email") String email);
}
