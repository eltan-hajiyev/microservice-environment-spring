package excludeautoscan.internal_service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Eltan Hajiyev
 *
 * We will use it for internal services.
 * Created to avoid attacks.
 * It will not included to swagger also in zuul security configuration we are added denayAll for path "/internal".
 * 
 * Overriding RequestMapping
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@RequestMapping(path = "/internal/v23oF54Dvbk57pbwG4nx2bvcHY3Bdv2jBsj")
public @interface InternalService {
	 @AliasFor(annotation = RequestMapping.class, attribute = "headers")
	 String value();
}
