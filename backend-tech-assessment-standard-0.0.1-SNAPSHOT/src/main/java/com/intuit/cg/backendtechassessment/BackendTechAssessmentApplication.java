package com.intuit.cg.backendtechassessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@Configuration
@EnableAutoConfiguration  // Sprint Boot Auto Configuration
@ComponentScan(basePackages = "com.intuit.cg.backendtechassessment")
public class BackendTechAssessmentApplication extends SpringBootServletInitializer {
	
	private static final Class<BackendTechAssessmentApplication> backendTechAssessmentApplication = BackendTechAssessmentApplication.class;
	
	public static void main(String[] args) {
		SpringApplication.run(backendTechAssessmentApplication, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(backendTechAssessmentApplication);
    }
}
