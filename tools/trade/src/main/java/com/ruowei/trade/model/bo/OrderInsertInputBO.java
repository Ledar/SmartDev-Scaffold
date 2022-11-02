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
public class OrderInsertInputBO {
  private String orderNumber;

  private String orderInfo;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(orderNumber);
    args.add(orderInfo);
    return args;
  }
}
