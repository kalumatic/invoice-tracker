package com.progrunners.invoicetracker.repository;

import com.progrunners.invoicetracker.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    List<Invoice> findByUsername(String username);
}
