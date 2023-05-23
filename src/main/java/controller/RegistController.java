package controller;

import domain.Register;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.RegistService;

@RequestMapping("/regist")
@Controller
public class RegistController {

    private RegistService registService;

    public void setRegistService(RegistService registService) {
        this.registService = registService;
    }

    @GetMapping
    public String registPage(Register register) {
        return "/regist/registForm";
    }

    @PostMapping
    public String regist(Register register) {
        long check = registService.insertInfo(register);
        if(check == -1) {
            return "/regist/registForm";
        }
        return "../../index";
    }
}
