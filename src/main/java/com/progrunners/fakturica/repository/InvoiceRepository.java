package com.progrunners.fakturica.repository;

import com.progrunners.fakturica.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    List<Invoice> findByUsername(String username);
}
