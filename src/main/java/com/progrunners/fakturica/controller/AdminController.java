package com.progrunners.fakturica.controller;

import com.progrunners.fakturica.entity.Invoice;
import com.progrunners.fakturica.entity.UserInfo;
import com.progrunners.fakturica.service.InvoiceService;
import com.progrunners.fakturica.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private InvoiceService invoiceService;
    private UserInfoService userInfoService;

    @Autowired
    public AdminController(InvoiceService invoiceService, UserInfoService userInfoService) {
        this.invoiceService = invoiceService;
        this.userInfoService = userInfoService;
    }

    @GetMapping("/main")
    public String showAdminMain() {
        return "admin/main";
    }

    @GetMapping("/list-invoices")
    public String showInvoicesList(Model model) {
        List<Invoice> invoiceList = invoiceService.findAll();

        model.addAttribute("invoiceList", invoiceList);

        return "admin/invoice-list";
    }

    @GetMapping("/list-users")
    public String showUsersList(Model model) {
        List<UserInfo> userList = userInfoService.findAll();

        model.addAttribute("userList", userList);

        return "admin/user-list";
    }

}
