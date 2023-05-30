package config;

import controller.BoardController;
import controller.LoginController;
import controller.RegistController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.AuthService;
import service.BoardService;
import service.LoginService;
import service.RegistService;

@Configuration
public class ControllerConfig {

    @Autowired
    private RegistService registService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private AuthService authService;
    @Autowired
    private BoardService boardService;

    @Bean
    public RegistController registController() {
        RegistController controller = new RegistController();
        controller.setRegistService(registService);
        return controller;
    }

    @Bean
    public LoginController loginController() {
        LoginController controller = new LoginController();
        controller.setLoginService(loginService);
        controller.setAuthService(authService);
        return controller;
    }

    @Bean
    public BoardController boardController() {
        BoardController controller = new BoardController();
        controller.setBoardDao(boardService);
        return controller;
    }
}
