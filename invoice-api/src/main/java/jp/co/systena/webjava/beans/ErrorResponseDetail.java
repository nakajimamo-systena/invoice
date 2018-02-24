package jp.co.systena.webjava.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.CaseFormat;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.FieldError;

/**
 * The Class ErrorResponseDetail.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseDetail implements Serializable {

  /** The Constant E400001. */
  @JsonIgnore
  public static final String E400001 = "E400001";

  /** The Constant E400005. */
  @JsonIgnore
  public static final String E400005 = "E400005";

  /** The Constant E400001_MESSAGE. */
  public static final String E400001_MESSAGE = "%sは必須項目です。";

  /** The Constant E400005_MESSAGE. */
  public static final String E400005_MESSAGE = "%sは半角英数字、記号(.)で入力してください。";

  /** The error map. */
  @JsonIgnore
  public static Map<String, String> errorMap = new HashMap<String, String>() {
    {
      put(E400001, E400001_MESSAGE);
      put(E400005, E400005_MESSAGE);
    }
  };

  /** The param. */
  @JsonProperty("param")
  private String param;

  /** The code. */
  @JsonProperty("code")
  private String code;

  /** The message. */
  @JsonProperty("message")
  private String message;

  /**
   * Instantiates a new error response detail.
   *
   * @param error the error
   */
  public ErrorResponseDetail(FieldError error) {
    // フィールド名
    String param = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, error.getField());
    this.setParam(param);
    // エラーコード
    String code = error.getDefaultMessage();
    this.setCode(code);
    // エラーメッセージ
    this.setMessage(String.format(errorMap.get(code), param));
  }
}