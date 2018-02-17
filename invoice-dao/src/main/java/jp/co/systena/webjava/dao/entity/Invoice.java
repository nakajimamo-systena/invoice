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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Invoice implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "invoice_no", nullable = false)
  private int invoiceNo;

  @Column(name = "invoice_status", nullable = false)
  private String invoiceStatus;

  @Column(name = "invoice_create_date", nullable = false)
  private Date invoiceCreateDate;

  @Column(name = "invoice_title", nullable = false)
  private String invoiceTitle;

  @Column(name = "invoice_amt", nullable = false)
  private int invoiceAmt;

  @Column(name = "tax_amt", nullable = true)
  private int taxAmt;

  @Column(name = "invoice_start_date", nullable = true)
  private Date invoiceStartDate;

  @Column(name = "invoice_end_date", nullable = false)
  private Date invoiceEndDate;

  @Column(name = "invoice_note", nullable = true)
  private String invoiceNote;

  @Column(name = "create_user", nullable = false)
  private String createUser;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Tokyo")
  @Column(name = "create_datetime", nullable = false)
  private Timestamp createDatetime;

  @Column(name = "update_user", nullable = true)
  private String updateUser;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Tokyo")
  @Column(name = "update_datetime", nullable = true)
  private Timestamp updateDatetime;

  @Column(name = "del_flg", nullable = true)
  private String delFlg;

  @ManyToOne
  @JoinColumn(name = "client_no")
  private Client client;
}