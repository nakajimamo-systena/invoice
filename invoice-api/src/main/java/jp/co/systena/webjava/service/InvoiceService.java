package jp.co.systena.webjava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.systena.webjava.dao.entity.Invoice;
import jp.co.systena.webjava.dao.repository.InvoiceRepository;

@Service
@Transactional
public class InvoiceService {

  @Autowired
  InvoiceRepository invoiceRepository;

  public Invoice save(Invoice invoice) {
    return invoiceRepository.save(invoice);
  }

  public List<Invoice> findAll() {
    return invoiceRepository.findAll();
  }

  public Invoice findOne(Integer id) {
    return invoiceRepository.findOne(id);
  }
}