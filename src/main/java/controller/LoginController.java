package controller;

import domain.AuthInfo;
import domain.Login;
import exception.LoginFailException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.AuthService;
import service.LoginService;
import validator.LoginValidator;

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
    public String postLogin(Login login, HttpSession session, Errors errors) {
        new LoginValidator().validate(login, errors);
        if(errors.hasErrors()) {
            return "login/loginForm";
        }
        try {
            loginService.checkLogin(login);
            AuthInfo authInfo = authService.authenticate(login);
            session.setAttribute("authInfo", authInfo);
            return "../../index";
        } catch (LoginFailException e) {
            errors.rejectValue("id", "loginError");
            return "login/loginForm";
        }
    }
}
