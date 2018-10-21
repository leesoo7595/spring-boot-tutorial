package org.isooproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    /**
     * Viewname (String) --> ViewResolver --> View(view)
     * @param model
     * @return
     */
    @GetMapping("${index.path}")
    public String hello(Model model, @RequestParam String name) {
        model.addAttribute("name", "leesoo");
        return "hello";
    }
}
