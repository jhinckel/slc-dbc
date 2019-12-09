package br.com.dbc.slc;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.dbc.slc.persistence.GenericRepositoryImpl;

@EnableJpaAuditing
@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = GenericRepositoryImpl.class)
@EnableAutoConfiguration
public class SLCApp {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SLCApp.class);

        application.setBannerMode(Banner.Mode.OFF);

        application.run(args);
    }

}
