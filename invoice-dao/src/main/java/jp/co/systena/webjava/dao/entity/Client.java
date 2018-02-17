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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "client_no", nullable = false)
  private int clientNo;

  @Column(name = "client_charge_last_name", nullable = false)
  private String clientChargeLastName;

  @Column(name = "client_charge_first_name", nullable = false)
  private String clientChargeFirstName;

  @Column(name = "client_name", nullable = false)
  private String clientName;

  @Column(name = "client_address", nullable = false)
  private String clientAddress;

  @Column(name = "client_tel", nullable = false)
  private String clientTel;

  @Column(name = "client_fax", nullable = true)
  private String clientFax;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Tokyo")
  @Column(name = "create_datetime", nullable = false)
  private Timestamp createDatetime;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Tokyo")
  @Column(name = "update_datetime", nullable = false)
  private Timestamp updateDatetime;

  @Column(name = "del_flg", nullable = false)
  private String delFlg;
}