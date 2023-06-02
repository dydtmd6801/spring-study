package config;

import controller.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.*;

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
    @Autowired
    private ChangeInfoService changeInfoService;

    @Bean
    public IndexController indexController() {
        return new IndexController();
    }

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

    @Bean
    public MyPageController myPageController() {
        return new MyPageController();
    }

    @Bean
    public LogoutController logoutController() {
        return new LogoutController();
    }

    @Bean
    public ChangeInfoController changeInfoController() {
        ChangeInfoController controller = new ChangeInfoController();
        controller.setChangeInfoService(changeInfoService);
        return controller;
    }
}
