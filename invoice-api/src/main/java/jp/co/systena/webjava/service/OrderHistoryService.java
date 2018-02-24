package jp.co.systena.webjava.service;

import java.sql.Timestamp;
import java.util.List;
import jp.co.systena.webjava.dao.entity.OrderHistory;
import jp.co.systena.webjava.dao.repository.OrderHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The Class OrderHistoryService.
 */
@Service
@Transactional
public class OrderHistoryService {

  /** The order history repository. */
  @Autowired
  OrderHistoryRepository orderHistoryRepository;

  /**
   * Find by client no and create period.
   *
   * @param clientNo the client no
   * @param startCreateDatetime the start create datetime
   * @param endCreateDatetime the end create datetime
   * @return the list
   */
  public List<OrderHistory> findByClientNoAndCreatePeriod(
          Integer clientNo,
          Timestamp startCreateDatetime,
          Timestamp endCreateDatetime
  ) {
    return orderHistoryRepository.findByClientNoAndCreatePeriod(
            clientNo,
            startCreateDatetime,
            endCreateDatetime
    );
  }
}