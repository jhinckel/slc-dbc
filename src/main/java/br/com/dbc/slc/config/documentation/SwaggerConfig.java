package br.com.dbc.slc.config.documentation;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final String VERSION_10 = "1.0";

	private static final String BASE_PACKAGE = "br.com.dbc.slc";
	private static final String[] MEDIA_TYPES = {MediaType.APPLICATION_JSON_VALUE};

	@Bean
    public Docket createRestApi10() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
            .paths(PathSelectors.any())
            .build()
            .consumes(Arrays.stream(MEDIA_TYPES).collect(Collectors.toSet()))
            .produces(Arrays.stream(MEDIA_TYPES).collect(Collectors.toSet()))
            .apiInfo(apiInfo(VERSION_10));
    }

    private ApiInfo apiInfo(String version) {
        return new ApiInfoBuilder()
            .title("SLC System")
            .description("SLC System Service")
            .version(version)
            .build();
    }

}
