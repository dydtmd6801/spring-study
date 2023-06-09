package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ErrorController {

    @GetMapping("/error/{errorNo}")
    public String errorHandler(@PathVariable("errorNo") int errorNo, Model model) {
        model.addAttribute("errorNo", errorNo);
        return "/error/errorHandler";
    }
}
