package com.progrunners.fakturica.controller;

import com.progrunners.fakturica.entity.User;
import com.progrunners.fakturica.service.InvoiceService;
import com.progrunners.fakturica.service.UserService;
import com.progrunners.fakturica.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController
{

    private InvoiceService invoiceService;
    private UserService userService;

    @Autowired
    public UserController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/main")
    public String showMain(Model model) {

        return "user/main";
    }

    @GetMapping("/invoice-history")
    public String showInvoiceHistory() {

    }
}