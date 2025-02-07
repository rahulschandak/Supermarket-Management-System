package model;

import java.util.HashMap;

public enum EmployeeRole {

  Regular ("Regular"),
  InventoryManager ("InventoryManager"),
  Admin ("Admin");
  private final String name;

  private EmployeeRole(String s) {
    name = s;
  }

  public boolean equalsName(String otherName) {
    return name.equals(otherName);
  }

  public static EmployeeRole role(String name) {
    var map = new HashMap<String, EmployeeRole>();
    map.put("Regular", EmployeeRole.Regular);
    map.put("InventoryManager", EmployeeRole.InventoryManager);
    map.put("Admin", EmployeeRole.Admin);
    return map.get(name);
  }

  public String toString() {
    return this.name;
  }
}
