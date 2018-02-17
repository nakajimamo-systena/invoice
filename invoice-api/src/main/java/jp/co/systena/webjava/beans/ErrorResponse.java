package jp.co.systena.webjava.beans;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse implements Serializable {

	@JsonProperty("message")
	private String message;

	@JsonProperty("errors")
	private List<ErrorResponseDetail> errors;
}
