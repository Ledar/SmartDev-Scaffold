package com.ruowei.trade.service;

import com.ruowei.trade.constants.ContractConstants;
import com.ruowei.trade.model.bo.OrderInsertInputBO;
import com.ruowei.trade.model.bo.OrderRemoveInputBO;
import com.ruowei.trade.model.bo.OrderSelectInputBO;
import com.ruowei.trade.model.bo.OrderUpdateInputBO;
import java.lang.Exception;
import java.lang.String;
import javax.annotation.PostConstruct;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fisco.bcos.sdk.v3.client.Client;
import org.fisco.bcos.sdk.v3.transaction.manager.AssembleTransactionProcessor;
import org.fisco.bcos.sdk.v3.transaction.manager.TransactionProcessorFactory;
import org.fisco.bcos.sdk.v3.transaction.model.dto.CallResponse;
import org.fisco.bcos.sdk.v3.transaction.model.dto.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Data
public class OrderService {
  @Value("${contract.orderAddress}")
  private String address;

  @Autowired
  private Client client;

  AssembleTransactionProcessor txProcessor;

  @PostConstruct
  public void init() throws Exception {
    this.txProcessor = TransactionProcessorFactory.createAssembleTransactionProcessor(this.client, this.client.getCryptoSuite().getCryptoKeyPair());
  }

  public TransactionResponse update(OrderUpdateInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ContractConstants.OrderAbi, "update", input.toArgs());
  }

  public TransactionResponse remove(OrderRemoveInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ContractConstants.OrderAbi, "remove", input.toArgs());
  }

  public CallResponse select(OrderSelectInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ContractConstants.OrderAbi, "select", input.toArgs());
  }

  public TransactionResponse insert(OrderInsertInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ContractConstants.OrderAbi, "insert", input.toArgs());
  }
}
