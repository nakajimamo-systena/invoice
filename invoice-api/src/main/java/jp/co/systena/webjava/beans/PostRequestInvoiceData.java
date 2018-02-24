package jp.co.systena.webjava.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * The Class PostRequestInvoiceData.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostRequestInvoiceData implements Serializable {

  /** The client no. */
  @JsonProperty("client_no")
  @NotEmpty(message = ErrorResponseDetail.E400001)
  private String clientNo;

  /** The invoice title. */
  @JsonProperty("invoice_title")
  @NotEmpty(message = ErrorResponseDetail.E400001)
  private String invoiceTitle;

  /** The invoice start date. */
  @JsonProperty("invoice_start_date")
  @NotEmpty(message = ErrorResponseDetail.E400001)
  private String invoiceStartDate;

  /** The invoice end date. */
  @JsonProperty("invoice_end_date")
  @NotEmpty(message = ErrorResponseDetail.E400001)
  private String invoiceEndDate;

  /** The invoice note. */
  @JsonProperty("invoice_note")
  @NotEmpty(message = ErrorResponseDetail.E400001)
  private String invoiceNote;

  /** The create user. */
  @JsonProperty("create_user")
  @NotEmpty(message = ErrorResponseDetail.E400001)
  @Pattern(regexp = "^[0-9a-zA-Z.]+$", message = ErrorResponseDetail.E400005)
  private String createUser;
}