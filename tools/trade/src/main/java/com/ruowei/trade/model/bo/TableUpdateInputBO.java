package com.ruowei.trade.model.bo;

import java.lang.Object;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fisco.bcos.sdk.v3.codec.datatypes.DynamicArray;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableUpdateInputBO {
  private String key;

  private DynamicArray<UpdateField> updateFields;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(key);
    args.add(updateFields);
    return args;
  }
}
