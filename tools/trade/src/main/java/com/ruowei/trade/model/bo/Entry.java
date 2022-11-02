package com.ruowei.trade.model.bo;

import java.lang.String;
import java.util.List;
import org.fisco.bcos.sdk.v3.codec.datatypes.DynamicArray;
import org.fisco.bcos.sdk.v3.codec.datatypes.DynamicStruct;
import org.fisco.bcos.sdk.v3.codec.datatypes.Utf8String;

public class Entry extends DynamicStruct {
  public String key;

  public List<String> fields;

  public Entry(Utf8String key, DynamicArray<Utf8String> fields) {
    super(key,fields);
    this.key = key.getValue();
    this.fields = fields.getValue().stream().map(org.fisco.bcos.sdk.v3.codec.datatypes.Utf8String::getValue).collect(java.util.stream.Collectors.toList());
  }

  public Entry(String key, List<String> fields) {
    super(new org.fisco.bcos.sdk.v3.codec.datatypes.Utf8String(key),new org.fisco.bcos.sdk.v3.codec.datatypes.DynamicArray<org.fisco.bcos.sdk.v3.codec.datatypes.Utf8String>(org.fisco.bcos.sdk.v3.codec.datatypes.Utf8String.class, fields.stream().map(org.fisco.bcos.sdk.v3.codec.datatypes.Utf8String::new).collect(java.util.stream.Collectors.toList())));
    this.key = key;
    this.fields = fields;
  }
}
