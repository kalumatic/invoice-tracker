package com.progrunners.fakturica.service;

import com.progrunners.fakturica.entity.Invoice;
import com.progrunners.fakturica.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceRepository invoiceRepository;


    @Autowired
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice findById(int id) {
        return invoiceRepository.findById(id).get();
    }

    @Override
    public List<Invoice> findByUsername(String username) {
        return invoiceRepository.findByUsername(username);
    }

    @Override
    public Invoice save(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }
}
