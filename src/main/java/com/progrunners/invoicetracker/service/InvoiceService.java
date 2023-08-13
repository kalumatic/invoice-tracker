package com.progrunners.invoicetracker.service;

import com.progrunners.invoicetracker.entity.Invoice;

import java.util.List;

public interface InvoiceService {

    List<Invoice> findAll();

    Invoice findById(int id);

    List<Invoice> findByUsername(String username);

    Invoice save(Invoice invoice);

}
