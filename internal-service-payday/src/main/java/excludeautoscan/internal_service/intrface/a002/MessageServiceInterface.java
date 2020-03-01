package excludeautoscan.internal_service.intrface.a002;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import excludeautoscan.internal_service.InternalService;
import excludeautoscan.internal_service.MicroServiceName;

@InternalService(MicroServiceName.MESSAGE_SERVICE + MicroServiceName.GROUP)
@FeignClient(MicroServiceName.MESSAGE_SERVICE)
public interface MessageServiceInterface {

	@PostMapping(value = "/send-message")
	Boolean sendMessage(@RequestParam("email") String email, @RequestParam("text") String text);

}
