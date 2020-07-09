package com.spring.herseyvar.controllers;

import com.spring.herseyvar.auth.UserAuthority;
import com.spring.herseyvar.models.CustomerFormRequest;
import com.spring.herseyvar.models.CustomerFormResponse;
import com.spring.herseyvar.services.CustomerService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;

@Controller
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @GetMapping("/Hesabim/KullaniciBilgileri")
    public String customerInfoPage(Model model, @Validated CustomerFormRequest request, @AuthenticationPrincipal UserAuthority loggedUser, BindingResult bindingResult) {

        request.setEmail(loggedUser.getUsername());
        CustomerFormResponse response = customerService.getCustomer(request);

        if (!response.isSuccess()) {
            bindingResult.reject(response.getMessage());
        }

        model.addAttribute("customer", request);

        return "user/CustomerInfoForm";

    }

    @PostMapping("/Hesabim/KullaniciBilgileri")
    public RedirectView processCustomerInfoPage(@Validated CustomerFormRequest request, @AuthenticationPrincipal UserAuthority loggedUser, BindingResult result) {

        request.setEmail(loggedUser.getUsername());
        CustomerFormResponse response = customerService.updateCustomer(request);

        if (!response.isSuccess()) {
            result.reject(response.getMessage());
            return new RedirectView("/Hesabim/KullaniciBilgileri");
        }

        return new RedirectView("/Hesabim/KullaniciBilgileri");
    }
}
