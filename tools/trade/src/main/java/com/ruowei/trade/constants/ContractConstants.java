package com.ruowei.trade.constants;

import java.lang.Exception;
import java.lang.RuntimeException;
import java.lang.String;

public class ContractConstants {
  public static String TableAbi;

  public static String TableBinary;

  public static String TableGmBinary;

  public static String OrderAbi;

  public static String OrderBinary;

  public static String OrderGmBinary;

  static {
    try {
      TableAbi = org.apache.commons.io.IOUtils.toString(Thread.currentThread().getContextClassLoader().getResource("abi/Table.abi"));
      TableBinary = org.apache.commons.io.IOUtils.toString(Thread.currentThread().getContextClassLoader().getResource("bin/ecc/Table.bin"));
      TableGmBinary = org.apache.commons.io.IOUtils.toString(Thread.currentThread().getContextClassLoader().getResource("bin/sm/Table.bin"));
      OrderAbi = org.apache.commons.io.IOUtils.toString(Thread.currentThread().getContextClassLoader().getResource("abi/Order.abi"));
      OrderBinary = org.apache.commons.io.IOUtils.toString(Thread.currentThread().getContextClassLoader().getResource("bin/ecc/Order.bin"));
      OrderGmBinary = org.apache.commons.io.IOUtils.toString(Thread.currentThread().getContextClassLoader().getResource("bin/sm/Order.bin"));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
