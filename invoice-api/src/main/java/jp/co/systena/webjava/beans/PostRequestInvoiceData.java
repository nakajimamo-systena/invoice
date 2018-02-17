package jp.co.systena.webjava.beans;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostRequestInvoiceData implements Serializable {

	@JsonProperty("client_no")
	@NotEmpty(message = "")
	private String clientNo;

	@JsonProperty("invoice_title")
	@NotEmpty(message = "")
	private String invoiceTitle;

	@JsonProperty("invoice_start_date")
	@NotEmpty(message = "")
	private String invoiceStartDate;

	@JsonProperty("invoice_end_date")
	@NotEmpty(message = "")
	private String invoiceEndDate;

	@JsonProperty("invoice_note")
	@NotEmpty(message = "")
	private String invoiceNote;

	@JsonProperty("create_user")
	@NotEmpty(message = "")
	private String createUser;
}
