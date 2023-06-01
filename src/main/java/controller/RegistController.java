package controller;

import domain.Register;
import exception.DuplicateMemberException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.RegistService;
import validator.RegistValidator;

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
    public String regist(Register register, Errors errors) {
        new RegistValidator().validate(register, errors);
        if(errors.hasErrors()) {
            return "/regist/registForm";
        }
        try {
            if(!register.getPassword().equals(register.getConfirmPassword())){
                errors.rejectValue("confirmPassword","notMatch");
                return "/regist/registForm";
            }
            registService.insertInfo(register);
            return "../../index";
        } catch (DuplicateMemberException e) {
            errors.rejectValue("userId", "duplicate");
            return "/regist/registForm";
        }
    }
}
