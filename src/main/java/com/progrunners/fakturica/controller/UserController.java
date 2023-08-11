package com.progrunners.fakturica.controller;

import com.progrunners.fakturica.entity.Invoice;
import com.progrunners.fakturica.entity.User;
import com.progrunners.fakturica.entity.UserInfo;
import com.progrunners.fakturica.service.InvoiceService;
import com.progrunners.fakturica.service.UserInfoService;
import com.progrunners.fakturica.service.UserService;
import com.progrunners.fakturica.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController
{

    private InvoiceService invoiceService;
    private UserService userService;
    private UserInfoService userInfoService;

    @Autowired
    public UserController(InvoiceService invoiceService, UserService userService, UserInfoService userInfoService) {
        this.invoiceService = invoiceService;
        this.userService = userService;
        this.userInfoService = userInfoService;
    }

    @GetMapping("/main")
    public String showMain(Principal principal, Model model) {
        String username = principal.getName();

        model.addAttribute("user", userService.findById(username));

        return "user/main";
    }

    @GetMapping("/invoice-history")
    public String showInvoiceHistory(Principal principal, Model model) {
        String username = principal.getName();

        List<Invoice> invoiceHistory = invoiceService.findByUsername(username);

        model.addAttribute("invoices", invoiceHistory);

        return "user/invoice-history";
    }

    @GetMapping("/create-new-invoice")
    public String showCreateNewInvoiceForm(Principal principal, Model model) {
        String username = principal.getName();

        Invoice invoice = new Invoice();

        invoice.setUsername(username);

        model.addAttribute("invoice", invoice);

        return "/user/create-new-invoice-form";
    }

    @PostMapping("/create-new-invoice/save")
    public String saveInvoice(@ModelAttribute("invoice") Invoice invoice) {
        invoiceService.save(invoice);

        return "redirect:/user/invoice-history";
    }

    @GetMapping("/update-personal-info")
    public String showUpdatePersonalInfoForm(Principal principal, Model model) {
        String username = principal.getName();

        UserInfo userInfo = userInfoService.findById(username);

        model.addAttribute("userInfo", userInfo);

        return "/user/update-personal-info-form";
    }

    @PostMapping("/update-personal-info/save")
    public String saveUserInfo(@ModelAttribute("userInfo") UserInfo userInfo) {
        userInfoService.save(userInfo);

        return "redirect:/user/main";
    }
}
