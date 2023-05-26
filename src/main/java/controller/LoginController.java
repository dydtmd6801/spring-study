package controller;

import domain.AuthInfo;
import domain.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.AuthService;
import service.LoginService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    private LoginService loginService;
    private AuthService authService;

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public String getLogin(Login login) {
        return "login/loginForm";
    }

    @PostMapping
    public String postLogin(Login login, HttpSession session, Model model) {
        int loginState = loginService.checkLogin(login);

        if(loginState == 1) {
            AuthInfo authInfo = authService.authenticate(login);
            session.setAttribute("authInfo", authInfo);
            return "../../index";
        }

        model.addAttribute("loginState", loginState);
        return "login/loginForm";
    }
}
