package model;

import java.util.HashMap;

import model.EmployeeRole;

public enum Category {
  Perishable (1),
  NonPerishable (2);
  private final int name;

  private Category(int s) {
    name = s;
  }

  public static int value(String value) {
    var map = new HashMap<String, Integer>();
    map.put("Perishable", 1);
    map.put("NonPerishable", 2);
    return map.get(value);
  }

}
