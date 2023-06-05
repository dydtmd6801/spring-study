package controller;

import domain.AuthInfo;
import domain.ChangeInfo;
import exception.NotFoundUserInfoException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.ChangeInfoService;
import validator.ChangeInfoValidator;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/myPage/changeInfo")
public class ChangeInfoController {

    private ChangeInfoService changeInfoService;

    public void setChangeInfoService(ChangeInfoService changeInfoService) {
        this.changeInfoService = changeInfoService;
    }

    @GetMapping
    public String NotAllowAccess(ChangeInfo changeInfo, HttpSession session) {
        AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
        if(authInfo == null) {
            return "redirect:/index";
        }
        return "myPage/changeInfo";
    }

    @PostMapping
    public String changeInfo(ChangeInfo changeInfo, HttpSession session, Errors errors) {
        new ChangeInfoValidator().validate(changeInfo, errors);
        if(errors.hasErrors()) {
            return "myPage/changeInfo";
        }
        try {
            AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
            changeInfoService.changeInfo(authInfo.getUserId(), changeInfo);
            authInfo.setChangeInfo(changeInfo.getName(), changeInfo.getPhoneNumber());
            session.setAttribute("authInfo", authInfo);
            return "myPage/index";
        } catch (NotFoundUserInfoException e) {
            errors.rejectValue("name", "notFound");
            return "myPage/changeInfo";
        }
    }
}
