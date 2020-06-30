package com.spring.herseyvar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping("/anasayfa")
    public ModelAndView homePage() {
        return new ModelAndView("index");
    }

}
