package jp.co.systena.webjava.beans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseDetail implements Serializable {

	@JsonProperty("param")
	private String param;

	@JsonProperty("code")
	private String code;

	@JsonProperty("message")
	private String message;
}