package controller;

import domain.AuthInfo;
import domain.ChangeInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/myPage")
public class MyPageController {

    @GetMapping
    public String myPage(HttpSession session, Model model, ChangeInfo changeInfo) {
        AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
        if(authInfo == null) {
            return "redirect:/index";
        }
        model.addAttribute("authInfo", authInfo);
        return "myPage/index";
    }
}
