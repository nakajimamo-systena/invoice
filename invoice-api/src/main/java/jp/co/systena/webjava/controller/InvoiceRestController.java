package jp.co.systena.webjava.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import jp.co.systena.webjava.beans.ErrorResponse;
import jp.co.systena.webjava.beans.ErrorResponseDetail;
import jp.co.systena.webjava.beans.GetResponseInvoiceData;
import jp.co.systena.webjava.beans.PostRequestInvoiceData;
import jp.co.systena.webjava.common.Constants;
import jp.co.systena.webjava.common.InvoiceApiProperties;
import jp.co.systena.webjava.dao.entity.Client;
import jp.co.systena.webjava.dao.entity.Invoice;
import jp.co.systena.webjava.dao.entity.OrderHistory;
import jp.co.systena.webjava.service.ClientService;
import jp.co.systena.webjava.service.InvoiceService;
import jp.co.systena.webjava.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class InvoiceRestController.
 */
@RestController
@RequestMapping("/invoices")
public class InvoiceRestController {

  /** The invoice service. */
  @Autowired
  InvoiceService invoiceService;

  /** The order history servie. */
  @Autowired
  OrderHistoryService orderHistoryServie;

  /** The client servie. */
  @Autowired
  ClientService clientServie;

  /** The invoice prop. */
  @Autowired
  InvoiceApiProperties invoiceProp;

  /**
   * Gets the invoices.
   *
   * @return the invoices
   */
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<Object> getInvoices() {

    // 請求書一覧を取得
    List<Invoice> invoices = invoiceService.findAll();
    List<GetResponseInvoiceData> responseData = new ArrayList<GetResponseInvoiceData>();
    for (Invoice invoice : invoices) {
      responseData.add(new GetResponseInvoiceData(invoice));
    }

    return new ResponseEntity<Object>(responseData, null, HttpStatus.OK);
  }

  /**
   * Gets the invoice.
   *
   * @param invoiceNo the invoice no
   * @return the invoice
   */
  @RequestMapping(method = RequestMethod.GET, value = "{invoiceNo}")
  public ResponseEntity<Object> getInvoice(@PathVariable Integer invoiceNo) {

    // 請求書を取得
    Invoice invoice = invoiceService.findOne(invoiceNo);
    GetResponseInvoiceData responseData = new GetResponseInvoiceData(invoice);

    return new ResponseEntity<Object>(responseData, null, HttpStatus.OK);
  }

  /**
   * Post invoice.
   *
   * @param requestData the request data
   * @param result the result
   * @return the response entity
   * @throws ParseException the parse exception
   */
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Object> postInvoice(
          @RequestBody @Valid PostRequestInvoiceData requestData,
          BindingResult result
  ) throws ParseException {

    // 入力エラー
    if (result.hasFieldErrors()) {
      // 詳細エラー情報
      List<ErrorResponseDetail> errorDetails = new ArrayList<ErrorResponseDetail>();
      List<FieldError> errors = result.getFieldErrors();
      for (FieldError error : errors) {
        ErrorResponseDetail errorDetail = new ErrorResponseDetail(error);
        errorDetails.add(errorDetail);
      }

      // エラー情報
      ErrorResponse responseData = new ErrorResponse(
          ErrorResponse.VALIDATION_FAILED,
          errorDetails
      );
      return new ResponseEntity<Object>(responseData, null, HttpStatus.BAD_REQUEST);
    }

    // 請求期間開始日
    String invoiceStartDate = requestData.getInvoiceStartDate();
    // 請求期間終了日
    String invoiceEndDate = requestData.getInvoiceEndDate();

    // 指定期間内の注文実績を取得
    SimpleDateFormat formatDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    List<OrderHistory> orderHistories = orderHistoryServie.findByClientNoAndCreatePeriod(
        Integer.parseInt(requestData.getClientNo()),
        new Timestamp(formatDateTime.parse(invoiceStartDate + " 00:00:00").getTime()),
        new Timestamp(formatDateTime.parse(invoiceEndDate + " 23:59:59").getTime()));

    // 請求金額
    int invoiceAmt = 0;
    for (OrderHistory orderHistory : orderHistories) {
      // 商品販売価格（税抜き）* 購入数量
      invoiceAmt += orderHistory.getItemPrice() * orderHistory.getItemCount();
    }
    // 消費税
    int taxAmt = (int)(invoiceAmt * invoiceProp.getTaxRate());

    // 現在日時
    long now = System.currentTimeMillis();
    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");

    // 登録情報
    Invoice invoice = new Invoice();

    // 顧客管理情報
    Client client = clientServie.findOne(Integer.parseInt(requestData.getClientNo()));

    // 顧客管理情報
    invoice.setClient(client);
    // 請求状態
    invoice.setInvoiceStatus(Constants.INVOICE_STATUS_NEW);
    // 請求書作成日
    invoice.setInvoiceCreateDate(new Date(now));
    // 請求書件名
    invoice.setInvoiceTitle(requestData.getInvoiceTitle());
    // 請求金額
    invoice.setInvoiceAmt(invoiceAmt);
    // 消費税
    invoice.setTaxAmt(taxAmt);
    // 請求期間開始日
    invoice.setInvoiceStartDate(new Date(formatDate.parse(invoiceStartDate).getTime()));
    // 請求期間終了日
    invoice.setInvoiceEndDate(new Date(formatDate.parse(invoiceEndDate).getTime()));
    // 備考
    invoice.setInvoiceNote(requestData.getInvoiceNote());
    // 登録ユーザID
    invoice.setCreateUser(requestData.getCreateUser());
    // 登録日時
    invoice.setCreateDatetime(new Timestamp(now));
    // 更新ユーザID
    invoice.setUpdateUser(requestData.getCreateUser());
    // 更新日時
    invoice.setUpdateDatetime(new Timestamp(now));
    // 削除フラグ
    invoice.setDelFlg(Constants.DEL_FLG_OFF);

    // 請求書を登録
    invoiceService.save(invoice);

    return new ResponseEntity<Object>(null, null, HttpStatus.CREATED);
  }
}