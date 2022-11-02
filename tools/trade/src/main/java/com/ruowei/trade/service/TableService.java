package com.ruowei.trade.service;

import com.ruowei.trade.constants.ContractConstants;
import com.ruowei.trade.model.bo.TableCountInputBO;
import com.ruowei.trade.model.bo.TableInsertInputBO;
import com.ruowei.trade.model.bo.TableRemove1InputBO;
import com.ruowei.trade.model.bo.TableRemoveInputBO;
import com.ruowei.trade.model.bo.TableSelect1InputBO;
import com.ruowei.trade.model.bo.TableSelectInputBO;
import com.ruowei.trade.model.bo.TableUpdate1InputBO;
import com.ruowei.trade.model.bo.TableUpdateInputBO;
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
public class TableService {
  @Value("${contract.tableAddress}")
  private String address;

  @Autowired
  private Client client;

  AssembleTransactionProcessor txProcessor;

  @PostConstruct
  public void init() throws Exception {
    this.txProcessor = TransactionProcessorFactory.createAssembleTransactionProcessor(this.client, this.client.getCryptoSuite().getCryptoKeyPair());
  }

  public TransactionResponse remove(TableRemoveInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ContractConstants.TableAbi, "remove", input.toArgs());
  }

  public CallResponse select(TableSelect1InputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ContractConstants.TableAbi, "select", input.toArgs());
  }

  public CallResponse count(TableCountInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ContractConstants.TableAbi, "count", input.toArgs());
  }

  public TransactionResponse insert(TableInsertInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ContractConstants.TableAbi, "insert", input.toArgs());
  }

  public TransactionResponse update(TableUpdateInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ContractConstants.TableAbi, "update", input.toArgs());
  }

  public TransactionResponse update(TableUpdate1InputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ContractConstants.TableAbi, "update", input.toArgs());
  }

  public TransactionResponse remove(TableRemove1InputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ContractConstants.TableAbi, "remove", input.toArgs());
  }

  public CallResponse select(TableSelectInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ContractConstants.TableAbi, "select", input.toArgs());
  }
}
