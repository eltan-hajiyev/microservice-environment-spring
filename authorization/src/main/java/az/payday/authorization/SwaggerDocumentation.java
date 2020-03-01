package az.payday.authorization;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import az.payday.authorization.controller.PublicController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerDocumentation {

	@Bean
	public Docket productUnregApi1() {
		return new Docket(DocumentationType.SWAGGER_2) //
				.groupName("Unregistered") //
				.globalOperationParameters(globalParametersForAll()) //
				.ignoredParameterTypes(User.class) //
				.select() //
				.apis(RequestHandlerSelectors.basePackage(PublicController.class.getPackage().getName())) //
				.paths(PathSelectors.regex("/(public).*")) //
				.build() //
				.apiInfo(metadata());
	}

	@Bean
	public Docket productRegApi2() {
		List<Parameter> list = globalParametersForRegistered();
		list.addAll(globalParametersForAll());

		return new Docket(DocumentationType.SWAGGER_2) //
				.groupName("Registered") //
				.globalOperationParameters(list) //
				.ignoredParameterTypes(User.class) //
				.select() //
				.apis(RequestHandlerSelectors.basePackage(PublicController.class.getPackage().getName())) //
				.paths(PathSelectors.regex("/(?!public).*")) //
				.build() //
				.apiInfo(metadata());
	}

	private List<Parameter> globalParametersForAll() {
		List<Parameter> parameter = new ArrayList<>();

		parameter.add(new ParameterBuilder() //
				.name("Accept-Language") //
				.description("Language header") //
				.modelRef(new ModelRef("string")) //
				.parameterType("header") //
				.required(false) //
				.build());

		return parameter;
	}

	private List<Parameter> globalParametersForRegistered() {
		List<Parameter> parameter = new ArrayList<>();

		parameter.add(new ParameterBuilder() //
				.name("Authorization") //
				.description("Authorization header") //
				.modelRef(new ModelRef("string")) //
				.parameterType("header") //
				.required(true) //
				.build());

		return parameter;
	}

	private ApiInfo metadata() {
		return new ApiInfoBuilder() //
				.title("Authorization service documentation") //
				.description("documentation") //
				.version("1.0.0") //
				.build();
	}

}