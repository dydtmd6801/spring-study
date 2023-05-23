package config;

import controller.RegistController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {

    @Bean
    public RegistController registController() {
        return new RegistController();
    }
}
