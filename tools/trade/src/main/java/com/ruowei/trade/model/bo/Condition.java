package com.ruowei.trade.model.bo;

import java.lang.String;
import java.math.BigInteger;
import org.fisco.bcos.sdk.v3.codec.datatypes.DynamicStruct;
import org.fisco.bcos.sdk.v3.codec.datatypes.Utf8String;
import org.fisco.bcos.sdk.v3.codec.datatypes.generated.Uint8;

public class Condition extends DynamicStruct {
  public BigInteger op;

  public String value;

  public Condition(Uint8 op, Utf8String value) {
    super(op,value);
    this.op = op.getValue();
    this.value = value.getValue();
  }

  public Condition(BigInteger op, String value) {
    super(new org.fisco.bcos.sdk.v3.codec.datatypes.generated.Uint8(op),new org.fisco.bcos.sdk.v3.codec.datatypes.Utf8String(value));
    this.op = op;
    this.value = value;
  }
}
