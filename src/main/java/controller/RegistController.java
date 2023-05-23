package controller;

import domain.Register;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistController {

    @RequestMapping("/regist")
    public String regist(Register register) {
        return "/regist/registForm";
    }

}
