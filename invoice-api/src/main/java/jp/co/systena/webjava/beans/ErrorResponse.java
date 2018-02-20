package jp.co.systena.webjava.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse implements Serializable {

  // システムエラー
  @JsonIgnore
  public static final String SYSTEM_ERROR = "System Error";

  // 入力エラー
  @JsonIgnore
  public static final String VALIDATION_FAILED = "Validation Failed";

  // エラーメッセージ
  @JsonProperty("message")
  private String message;

  // 詳細エラー情報
  @JsonProperty("errors")
  private List<ErrorResponseDetail> errors;
}