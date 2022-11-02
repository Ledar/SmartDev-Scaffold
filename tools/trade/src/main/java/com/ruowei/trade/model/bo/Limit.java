package com.ruowei.trade.model.bo;

import java.math.BigInteger;
import org.fisco.bcos.sdk.v3.codec.datatypes.StaticStruct;
import org.fisco.bcos.sdk.v3.codec.datatypes.generated.Uint32;

public class Limit extends StaticStruct {
  public BigInteger offset;

  public BigInteger count;

  public Limit(Uint32 offset, Uint32 count) {
    super(offset,count);
    this.offset = offset.getValue();
    this.count = count.getValue();
  }

  public Limit(BigInteger offset, BigInteger count) {
    super(new org.fisco.bcos.sdk.v3.codec.datatypes.generated.Uint32(offset),new org.fisco.bcos.sdk.v3.codec.datatypes.generated.Uint32(count));
    this.offset = offset;
    this.count = count;
  }
}
