package com.progrunners.fakturica.controller;

import com.progrunners.fakturica.entity.Invoice;
import com.progrunners.fakturica.entity.User;
import com.progrunners.fakturica.service.InvoiceService;
import com.progrunners.fakturica.service.UserService;
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
    private UserService userService;

    @Autowired
    public AdminController(InvoiceService invoiceService, UserService userService) {
        this.invoiceService = invoiceService;
        this.userService = userService;
    }

    @GetMapping("/main")
    public String showAdminMain() {
        return "admin/main";
    }

    @GetMapping("/list-invoices")
    public String showInvoicesList(Model model) {
        List<Invoice> invoiceList = invoiceService.findAll();

        model.addAttribute("invoiceList", invoiceList);

        return "admin/invoices-list";
    }

    @GetMapping("/list-users")
    public String showUsersList(Model model) {
        List<User> userList = userService.findAll();

        model.addAttribute("userList", userList);

        return "admin/users-list";
    }

}
