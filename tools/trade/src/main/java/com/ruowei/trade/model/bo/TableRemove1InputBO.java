package com.ruowei.trade.model.bo;

import java.lang.Object;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableRemove1InputBO {
  private String key;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(key);
    return args;
  }
}
