package jp.co.systena.webjava.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * The Class InvoiceApiProperties.
 */
@Data
@Configuration
@PropertySource(value = "classpath:invoice_api.properties", ignoreResourceNotFound = true)
public class InvoiceApiProperties {

  /** The tax rate. */
  @Value("${tax.rate}")
  private double taxRate;
}