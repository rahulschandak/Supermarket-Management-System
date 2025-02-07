package model;

import java.util.Date;

public class Order {

  private final int ID;
  private final Date date;
  private final Double Amount;

  public Order(int id, Date date, double amount) {
    this.ID = id;
    this.date = date;
    this.Amount = amount;
  }

  public int id() {
    return this.ID;
  }

  public Date date() {
    return this.date;
  }

  public Double amount() {
    return this.Amount;
  }
}
