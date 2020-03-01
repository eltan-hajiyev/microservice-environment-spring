package excludeautoscan.internal_service.intrface.a001;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import excludeautoscan.internal_service.InternalService;
import excludeautoscan.internal_service.MicroServiceName;


@InternalService(MicroServiceName.ACCOUNT + MicroServiceName.GROUP)
@FeignClient(value = MicroServiceName.ACCOUNT)
public interface AccountServiceInterface {
	@PostMapping("/createAccount")
	String createAccount(@RequestParam("idUser") Integer idUser);
}
