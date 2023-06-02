package controller;

import domain.AuthInfo;
import domain.ChangeInfo;
import domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import service.ChangeInfoService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/myPage/changeInfo")
public class ChangeInfoController {

    private ChangeInfoService changeInfoService;

    public void setChangeInfoService(ChangeInfoService changeInfoService) {
        this.changeInfoService = changeInfoService;
    }

    @GetMapping
    public String NotAllowAccess(ChangeInfo changeInfo) {
        return "redirect:/index";
    }

    @PostMapping
    public String changeInfo(ChangeInfo changeInfo, HttpSession session) {
        AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
        changeInfoService.changeInfo(authInfo.getUserId(), changeInfo);
        authInfo.setChangeInfo(changeInfo.getName(), changeInfo.getPhoneNumber());
        session.setAttribute("authInfo", authInfo);
        return "myPage/index";
    }
}
