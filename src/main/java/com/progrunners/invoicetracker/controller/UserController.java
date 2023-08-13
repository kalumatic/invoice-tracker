package com.progrunners.invoicetracker.controller;

import com.progrunners.invoicetracker.entity.Invoice;
import com.progrunners.invoicetracker.entity.UserInfo;
import com.progrunners.invoicetracker.service.InvoiceService;
import com.progrunners.invoicetracker.service.UserInfoService;
import com.progrunners.invoicetracker.service.UserService;
import jakarta.validation.Valid;
import org.apache.pdfbox.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

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

        return "user/create-new-invoice-form";
    }

    @PostMapping("/create-new-invoice/save")
    public String saveInvoice(@Valid @ModelAttribute("invoice") Invoice invoice, BindingResult bindingResult) {
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

    @GetMapping("/create-pdf/{id}")
    public String createPdf(@PathVariable("id") int id) throws IOException {
        Invoice invoice = invoiceService.findById(id);

        PDDocument document = new PDDocument();

        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true);

        contentStream.beginText();

        contentStream.newLineAtOffset(25, 700);
        contentStream.setLeading(14.5f);

        contentStream.setFont(PDType1Font.COURIER, 16);
        contentStream.showText("Invoice id: " + invoice.getId());
        contentStream.newLine();
        contentStream.newLine();

        contentStream.showText("Username: " + invoice.getUsername());
        contentStream.newLine();
        contentStream.newLine();

        contentStream.showText("Goods: " + invoice.getGoods());
        contentStream.newLine();
        contentStream.newLine();

        contentStream.showText("Amount: " + invoice.getAmount());
        contentStream.newLine();
        contentStream.newLine();

        contentStream.showText("Date : " + invoice.getDate());
        contentStream.newLine();
        contentStream.newLine();

        contentStream.showText("Price: " + invoice.getPrice());

        contentStream.endText();

        contentStream.close();

        document.save("src/main/resources/static/pdf/invoice" + invoice.getId() + ".pdf");
        document.close();


        return "redirect:/user/invoice-history";
    }

    @GetMapping(
            value = "/show-pdf/{id}",
            produces = MediaType.APPLICATION_PDF_VALUE
    )
    public @ResponseBody byte[] showPdf(@PathVariable("id") int id) throws IOException {
         InputStream in = getClass()
                    .getResourceAsStream("/static/pdf/invoice" + id + ".pdf");
        return IOUtils.toByteArray(in);
    }

}
