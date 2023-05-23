package config;

import controller.RegistController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.RegistService;

@Configuration
public class ControllerConfig {

    @Autowired
    private RegistService registService;

    @Bean
    public RegistController registController() {
        RegistController controller = new RegistController();
        controller.setRegistService(registService);
        return controller;
    }
}
