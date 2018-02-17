package jp.co.systena.webjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.systena.webjava.dao.entity.Client;
import jp.co.systena.webjava.dao.repository.ClientRepository;

@Service
@Transactional
public class ClientService {

  @Autowired
  ClientRepository clientRepository;

  public Client findOne(Integer id) {
    return clientRepository.findOne(id);
  }
}