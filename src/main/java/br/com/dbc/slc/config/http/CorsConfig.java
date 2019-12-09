package br.com.dbc.slc.config.http;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();

		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addExposedHeader(HttpHeaders.CONTENT_DISPOSITION);
		config.addAllowedMethod(HttpMethod.OPTIONS);
		config.addAllowedMethod(HttpMethod.HEAD);
		config.addAllowedMethod(HttpMethod.GET);

		source.registerCorsConfiguration("/**", config);

		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(source));

		bean.setOrder(0);

		return bean;
	}

}
