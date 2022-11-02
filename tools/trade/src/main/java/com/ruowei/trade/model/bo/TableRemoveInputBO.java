package com.ruowei.trade.model.bo;

import java.lang.Object;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fisco.bcos.sdk.v3.codec.datatypes.DynamicArray;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableRemoveInputBO {
  private DynamicArray<Condition> conditions;

  private Limit limit;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(conditions);
    args.add(limit);
    return args;
  }
}
