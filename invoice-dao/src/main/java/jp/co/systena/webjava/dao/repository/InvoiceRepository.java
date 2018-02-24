package jp.co.systena.webjava.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.systena.webjava.dao.entity.Invoice;

/**
 * The Interface InvoiceRepository.
 */
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}