package com.spring.herseyvar.controllers;

import com.spring.herseyvar.models.SignUpRequest;
import com.spring.herseyvar.models.SignUpResponse;
import com.spring.herseyvar.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/signup")
    public String signUpPage(Model model) {
        model.addAttribute("user", new SignUpRequest());
        return "user/SignUpForm";
    }

    @PostMapping("/signup")
    public String processSignUpPage(@Validated SignUpRequest signUpRequest, BindingResult bindingResult) {

        SignUpResponse response = userService.signUp(signUpRequest);

        if (!response.isSuccess()) {
            bindingResult.reject(response.getMessage());
            return "user/SignUpForm";
        }

        return "redirect:";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "user/Login";
    }

    @PostMapping("/login")
    public String processLoginPage() {
        return "redirect:";
    }

    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null)
            new SecurityContextLogoutHandler().logout(request, response, authentication);

        return "user/Login";
    }

}
