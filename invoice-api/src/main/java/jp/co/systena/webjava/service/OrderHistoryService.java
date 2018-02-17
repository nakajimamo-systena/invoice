package jp.co.systena.webjava.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.systena.webjava.dao.entity.OrderHistory;
import jp.co.systena.webjava.dao.repository.OrderHistoryRepository;

@Service
@Transactional
public class OrderHistoryService {

  @Autowired
  OrderHistoryRepository orderHistoryRepository;

  public List<OrderHistory> findByClientNoAndCreatePeriod(Integer clientNo, Timestamp startCreateDatetime, Timestamp endCreateDatetime) {
    return orderHistoryRepository.findByClientNoAndCreatePeriod(clientNo, startCreateDatetime, endCreateDatetime);
  }
}