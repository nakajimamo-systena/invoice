package jp.co.systena.webjava.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class ErrorResponse.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse implements Serializable {

  /** The Constant SYSTEM_ERROR. */
  @JsonIgnore
  public static final String SYSTEM_ERROR = "System Error";

  /** The Constant VALIDATION_FAILED. */
  @JsonIgnore
  public static final String VALIDATION_FAILED = "Validation Failed";

  /** The message. */
  @JsonProperty("message")
  private String message;

  /** The errors. */
  @JsonProperty("errors")
  private List<ErrorResponseDetail> errors;
}