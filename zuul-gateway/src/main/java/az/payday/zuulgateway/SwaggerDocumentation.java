package az.payday.zuulgateway;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Component
@EnableSwagger2
@Primary
public class SwaggerDocumentation implements SwaggerResourcesProvider{
	@Autowired
	ZuulProperties zuulProperties;

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        zuulProperties.getRoutes().values().forEach(r -> {
        	String link = r.getPath().replace("**", "v2/api-docs");
        	resources.add(swaggerResource(r.getServiceId(), link + "?group=Registered", "2.0"));
        	resources.add(swaggerResource(r.getServiceId(), link + "?group=Unregistered", "2.0"));
		});
        
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }

}
