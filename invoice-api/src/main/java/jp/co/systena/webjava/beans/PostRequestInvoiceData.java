package jp.co.systena.webjava.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostRequestInvoiceData implements Serializable {

  @JsonProperty("client_no")
  @NotEmpty(message = ErrorResponseDetail.E400001)
  private String clientNo;

  @JsonProperty("invoice_title")
  @NotEmpty(message = ErrorResponseDetail.E400001)
  private String invoiceTitle;

  @JsonProperty("invoice_start_date")
  @NotEmpty(message = ErrorResponseDetail.E400001)
  private String invoiceStartDate;

  @JsonProperty("invoice_end_date")
  @NotEmpty(message = ErrorResponseDetail.E400001)
  private String invoiceEndDate;

  @JsonProperty("invoice_note")
  @NotEmpty(message = ErrorResponseDetail.E400001)
  private String invoiceNote;

  @JsonProperty("create_user")
  @NotEmpty(message = ErrorResponseDetail.E400001)
  @Pattern(regexp = "^[0-9a-zA-Z.]+$", message = ErrorResponseDetail.E400005)
  private String createUser;
}