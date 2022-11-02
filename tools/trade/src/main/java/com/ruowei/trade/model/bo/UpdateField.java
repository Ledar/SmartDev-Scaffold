package com.ruowei.trade.model.bo;

import java.lang.String;
import org.fisco.bcos.sdk.v3.codec.datatypes.DynamicStruct;
import org.fisco.bcos.sdk.v3.codec.datatypes.Utf8String;

public class UpdateField extends DynamicStruct {
  public String columnName;

  public String value;

  public UpdateField(Utf8String columnName, Utf8String value) {
    super(columnName,value);
    this.columnName = columnName.getValue();
    this.value = value.getValue();
  }

  public UpdateField(String columnName, String value) {
    super(new org.fisco.bcos.sdk.v3.codec.datatypes.Utf8String(columnName),new org.fisco.bcos.sdk.v3.codec.datatypes.Utf8String(value));
    this.columnName = columnName;
    this.value = value;
  }
}
