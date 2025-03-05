package com.flyobs.customer_service.config;

import com.flyobs.customer_service.entities.Customer;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;


@Configuration
public class RestRepositoryConfig implements RepositoryRestConfigurer {
    //include Id on json return
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Customer.class);
    }
}
