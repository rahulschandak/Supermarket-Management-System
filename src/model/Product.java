package model;

import java.util.Date;

public class Product {

  private final int id;
  private final String name;
  private final int quantity;
  private final String category;
  private final int price;

  public Product(int id, String name, int quantity, String category, int price) {
    this.id = id;
    this.name = name;
    this.quantity = quantity;
    this.category = category;
    this.price = price;
  }

  public Product(int id, String name, int quantity) {
    this.id = id;
    this.name = name;
    this.quantity = quantity;
    this.category = "";
    this.price = 0;
  }


  public int id() {
    return this.id;
  }

  public String name() {
    return this.name;
  }

  public int quantity() {
    return this.quantity;
  }

  public String category() {
    return this.category;
  }

  public int price() {return this.price;}

}
