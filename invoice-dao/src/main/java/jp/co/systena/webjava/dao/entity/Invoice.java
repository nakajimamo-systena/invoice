package jp.co.systena.webjava.dao.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class Invoice.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Invoice implements Serializable {

  /** The invoice no. */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "invoice_no", nullable = false)
  private int invoiceNo;

  /** The invoice status. */
  @Column(name = "invoice_status", nullable = false)
  private String invoiceStatus;

  /** The invoice create date. */
  @Column(name = "invoice_create_date", nullable = false)
  private Date invoiceCreateDate;

  /** The invoice title. */
  @Column(name = "invoice_title", nullable = false)
  private String invoiceTitle;

  /** The invoice amt. */
  @Column(name = "invoice_amt", nullable = false)
  private int invoiceAmt;

  /** The tax amt. */
  @Column(name = "tax_amt", nullable = true)
  private int taxAmt;

  /** The invoice start date. */
  @Column(name = "invoice_start_date", nullable = true)
  private Date invoiceStartDate;

  /** The invoice end date. */
  @Column(name = "invoice_end_date", nullable = false)
  private Date invoiceEndDate;

  /** The invoice note. */
  @Column(name = "invoice_note", nullable = true)
  private String invoiceNote;

  /** The create user. */
  @Column(name = "create_user", nullable = false)
  private String createUser;

  /** The create datetime. */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Tokyo")
  @Column(name = "create_datetime", nullable = false)
  private Timestamp createDatetime;

  /** The update user. */
  @Column(name = "update_user", nullable = true)
  private String updateUser;

  /** The update datetime. */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Tokyo")
  @Column(name = "update_datetime", nullable = true)
  private Timestamp updateDatetime;

  /** The del flg. */
  @Column(name = "del_flg", nullable = true)
  private String delFlg;

  /** The client. */
  @ManyToOne
  @JoinColumn(name = "client_no")
  private Client client;
}