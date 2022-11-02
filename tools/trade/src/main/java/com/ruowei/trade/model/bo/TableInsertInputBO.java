package com.ruowei.trade.model.bo;

import java.lang.Object;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableInsertInputBO {
  private Entry entry;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(entry);
    return args;
  }
}
