package jp.co.systena.webjava.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.FieldError;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseDetail implements Serializable {

  // エラーコード（必須）
  @JsonIgnore
  public static final String E400001 = "E400001";

  // エラーコード（半角英数字記号）
  @JsonIgnore
  public static final String E400005 = "E400005";

  // エラーメッセージ（必須）
  public static final String E400001_MESSAGE = "%sは必須項目です。";

  // エラーメッセージ（半角英数字記号）
  public static final String E400005_MESSAGE = "%sは半角英数字、記号(.)で入力してください。";

  // エラーマップ
  @JsonIgnore
  public static Map<String, String> errorMap = new HashMap<String, String>() {
    {
      put(E400001, E400001_MESSAGE);
      put(E400005, E400005_MESSAGE);
    }
  };

  // フィールド名
  @JsonProperty("param")
  private String param;

  // エラーコード
  @JsonProperty("code")
  private String code;

  // エラーメッセージ
  @JsonProperty("message")
  private String message;

  public ErrorResponseDetail(FieldError error) {
    // フィールド名
    String param = error.getField();
    this.setParam(param);
    // エラーコード
    String code = error.getDefaultMessage();
    this.setCode(code);
    // エラーメッセージ
    this.setMessage(String.format(errorMap.get(code), param));
  }
}