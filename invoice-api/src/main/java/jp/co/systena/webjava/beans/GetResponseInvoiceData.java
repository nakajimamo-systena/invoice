package jp.co.systena.webjava.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import jp.co.systena.webjava.dao.entity.Client;
import jp.co.systena.webjava.dao.entity.Invoice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class GetResponseInvoiceData.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetResponseInvoiceData implements Serializable {

  /** The invoice no. */
  @JsonProperty("invoice_no")
  private String invoiceNo;

  /** The client name. */
  @JsonProperty("client_name")
  private String clientName;

  /** The client address. */
  @JsonProperty("client_address")
  private String clientAddress;

  /** The client tel. */
  @JsonProperty("client_tel")
  private String clientTel;

  /** The client fax. */
  @JsonProperty("client_fax")
  private String clientFax;

  /** The client charge name. */
  @JsonProperty("client_charge_name")
  private String clientChargeName;

  /** The invoice status. */
  @JsonProperty("invoice_status")
  private String invoiceStatus;

  /** The invoice create date. */
  @JsonProperty("invoice_create_date")
  private String invoiceCreateDate;

  /** The invoice title. */
  @JsonProperty("invoice_title")
  private String invoiceTitle;

  /** The invoice amt. */
  @JsonProperty("invoice_amt")
  private String invoiceAmt;

  /** The tax amt. */
  @JsonProperty("tax_amt")
  private String taxAmt;

  /** The invoice start date. */
  @JsonProperty("invoice_start_date")
  private String invoiceStartDate;

  /** The invoice end date. */
  @JsonProperty("invoice_end_date")
  private String invoiceEndDate;

  /** The invoice note. */
  @JsonProperty("invoice_note")
  private String invoiceNote;

  /** The create user. */
  @JsonProperty("create_user")
  private String createUser;

  /** The create datetime. */
  @JsonProperty("create_datetime")
  private String createDatetime;

  /** The update user. */
  @JsonProperty("update_user")
  private String updateUser;

  /** The update datetime. */
  @JsonProperty("update_datetime")
  private String updateDatetime;

  /**
   * Instantiates a new gets the response invoice data.
   *
   * @param invoice the invoice
   */
  public GetResponseInvoiceData(Invoice invoice) {
    // 顧客管理情報
    Client client = invoice.getClient();

    // 請求書管理番号
    this.setInvoiceNo(String.valueOf(invoice.getInvoiceNo()));
    // 法人名
    this.setClientName(client.getClientName());
    // 住所
    this.setClientAddress(client.getClientAddress());
    // 電話番号
    this.setClientTel(client.getClientTel());
    // FAX
    this.setClientFax(client.getClientFax());
    // 顧客担当者氏名
    this.setClientChargeName(client.getClientChargeLastName() + client.getClientChargeFirstName());
    // 請求状態
    this.setInvoiceStatus(invoice.getInvoiceStatus());
    // 請求書作成日
    this.setInvoiceCreateDate(invoice.getInvoiceCreateDate().toString());
    // 請求書件名
    this.setInvoiceTitle(invoice.getInvoiceTitle());
    // 請求金額
    this.setInvoiceAmt(String.valueOf(invoice.getInvoiceAmt()));
    // 消費税
    this.setTaxAmt(String.valueOf(invoice.getTaxAmt()));
    // 請求期間開始日
    this.setInvoiceStartDate(invoice.getInvoiceStartDate().toString());
    // 請求期間終了日
    this.setInvoiceEndDate(invoice.getInvoiceEndDate().toString());
    // 備考
    this.setInvoiceNote(invoice.getInvoiceNote());
    // 登録ユーザID
    this.setCreateUser(invoice.getCreateUser());
    // 登録日時
    this.setCreateDatetime(invoice.getCreateDatetime().toString());
    // 更新ユーザID
    this.setUpdateUser(invoice.getUpdateUser());
    // 更新日時
    this.setUpdateDatetime(invoice.getUpdateDatetime().toString());
  }
}
