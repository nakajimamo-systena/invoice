package jp.co.systena.webjava.beans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import jp.co.systena.webjava.dao.entity.Client;
import jp.co.systena.webjava.dao.entity.Invoice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetResponseInvoiceData implements Serializable {

	@JsonProperty("invoice_no")
	private String invoiceNo;

	@JsonProperty("client_name")
	private String clientName;

	@JsonProperty("client_address")
	private String clientAddress;

	@JsonProperty("client_tel")
	private String clientTel;

	@JsonProperty("client_fax")
	private String clientFax;

	@JsonProperty("client_charge_name")
	private String clientChargeName;

	@JsonProperty("invoice_status")
	private String invoiceStatus;

	@JsonProperty("invoice_create_date")
	private String invoiceCreateDate;

	@JsonProperty("invoice_title")
	private String invoiceTitle;

	@JsonProperty("invoice_amt")
	private String invoiceAmt;

	@JsonProperty("tax_amt")
	private String taxAmt;

	@JsonProperty("invoice_start_date")
	private String invoiceStartDate;

	@JsonProperty("invoice_end_date")
	private String invoiceEndDate;

	@JsonProperty("invoice_note")
	private String invoiceNote;

	@JsonProperty("create_user")
	private String createUser;

	@JsonProperty("create_datetime")
	private String createDatetime;

	@JsonProperty("update_user")
	private String updateUser;

	@JsonProperty("update_datetime")
	private String updateDatetime;

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
