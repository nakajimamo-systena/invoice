package jp.co.systena.webjava.dao.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jp.co.systena.webjava.dao.entity.OrderHistory;

public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Integer> {

  @Query("SELECT oh FROM OrderHistory oh"
          + " WHERE oh.clientNo = :clientNo"
          + " AND oh.createDatetime BETWEEN :startCreateDatetime AND :endCreateDatetime")
  public List<OrderHistory> findByClientNoAndCreatePeriod(
		  @Param("clientNo") int clientNo,
          @Param("startCreateDatetime") Timestamp startCreateDatetime,
          @Param("endCreateDatetime") Timestamp endCreateDatetime);
}