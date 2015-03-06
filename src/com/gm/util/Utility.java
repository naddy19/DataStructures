package com.gm.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utility {
  public static int readInteger() {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    try {
      return Integer.parseInt(reader.readLine());
    } catch (NumberFormatException e) {
      return Integer.MIN_VALUE;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return Integer.MIN_VALUE;
  }
}
