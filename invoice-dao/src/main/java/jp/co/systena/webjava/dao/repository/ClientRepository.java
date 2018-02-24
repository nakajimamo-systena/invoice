package jp.co.systena.webjava.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.systena.webjava.dao.entity.Client;

/**
 * The Interface ClientRepository.
 */
public interface ClientRepository extends JpaRepository<Client, Integer> {

}