package jp.co.systena.webjava.dao.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class Client.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client implements Serializable {

  /** The client no. */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "client_no", nullable = false)
  private int clientNo;

  /** The client charge last name. */
  @Column(name = "client_charge_last_name", nullable = false)
  private String clientChargeLastName;

  /** The client charge first name. */
  @Column(name = "client_charge_first_name", nullable = false)
  private String clientChargeFirstName;

  /** The client name. */
  @Column(name = "client_name", nullable = false)
  private String clientName;

  /** The client address. */
  @Column(name = "client_address", nullable = false)
  private String clientAddress;

  /** The client tel. */
  @Column(name = "client_tel", nullable = false)
  private String clientTel;

  /** The client fax. */
  @Column(name = "client_fax", nullable = true)
  private String clientFax;

  /** The create datetime. */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Tokyo")
  @Column(name = "create_datetime", nullable = false)
  private Timestamp createDatetime;

  /** The update datetime. */
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Tokyo")
  @Column(name = "update_datetime", nullable = false)
  private Timestamp updateDatetime;

  /** The del flg. */
  @Column(name = "del_flg", nullable = false)
  private String delFlg;
}