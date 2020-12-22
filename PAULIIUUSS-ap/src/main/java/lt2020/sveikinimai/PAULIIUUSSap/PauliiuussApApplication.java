package lt2020.sveikinimai.PAULIIUUSSap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class PauliiuussApApplication extends SpringBootServletInitializer {

	@Bean
	public Docket swaggerDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("it2020.sveikinimai"))
				.build();
	}
	private ApiInfo apiInfo(){
		return new ApiInfoBuilder()
				.title("IT Akademija REST Documentation")
				.version("v1")
				.build();
	}

	public static void main(String[] args) { SpringApplication.run(PauliiuussApApplication.class, args); }

	@Override
	protected SpringApplicationBuilder configure (SpringApplicationBuilder builder) {
		return builder.sources (PauliiuussApApplication.class);
	}
}
