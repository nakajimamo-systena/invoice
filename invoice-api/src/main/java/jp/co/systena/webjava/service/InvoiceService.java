package jp.co.systena.webjava.service;

import java.util.List;
import jp.co.systena.webjava.dao.entity.Invoice;
import jp.co.systena.webjava.dao.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Class InvoiceService.
 */
@Service
@Transactional
public class InvoiceService {

  /** The invoice repository. */
  @Autowired
  InvoiceRepository invoiceRepository;

  /**
   * Save.
   *
   * @param invoice the invoice
   * @return the invoice
   */
  public Invoice save(Invoice invoice) {
    return invoiceRepository.save(invoice);
  }

  /**
   * Find all.
   *
   * @return the list
   */
  public List<Invoice> findAll() {
    return invoiceRepository.findAll();
  }

  /**
   * Find one.
   *
   * @param id the id
   * @return the invoice
   */
  public Invoice findOne(Integer id) {
    return invoiceRepository.findOne(id);
  }
}