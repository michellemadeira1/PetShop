package com.PetShop.PetShop.Config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

	  @Bean
	    public GroupedOpenApi publicApi() {
	        return GroupedOpenApi.builder()
	                .group("public")
	                .pathsToMatch("/donoPet/**")
	                .build();
	    }
	  
	  @Bean
	    public GroupedOpenApi petApi() {
	        return GroupedOpenApi.builder()
	                .group("pets")
	                .pathsToMatch("/pets/**")
	                .build();
	    }
}
