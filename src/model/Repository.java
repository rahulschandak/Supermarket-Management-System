package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.dbconnect.Operations;

public class Repository implements IRepository {

  private final Operations repository;

  public Repository(Operations repository) {
    this.repository = repository;
  }

  @Override
  public void register(String username, String password, String firstName, String lastName,
                       LocalDate dob) throws Exception {
    String command = "CALL register('"+username + "','" + firstName + "','" +
            lastName + "','" + dob +"','"+password+"');";

    repository.executeWithResult(command);
  }

  @Override
  public boolean isUserValid(String username, String password) throws Exception  {
    String command = "SELECT isValidUser('" + username + "','" + password + "') isValidUser;";
    ResultSet result = repository.executeWithResult(command);
    var returnResult = false;
    while(result.next()) {
      returnResult = result.getBoolean("isValidUser");
    }
    return returnResult;
  }

  @Override
  public boolean isEmployeeValid(String username, String password) throws Exception {
    String command = "SELECT isValidEmployee('" + username + "','" + password + "') isValidUser;";
    ResultSet result = repository.executeWithResult(command);
    var returnResult = false;
    while(result.next()) {
      returnResult = result.getBoolean("isValidUser");
    }
    return returnResult;
  }

  @Override
  public List<Order> getOrderHistory(String username) throws Exception {
    String command = "CALL orderHistory('"+username + "');";
    var result = repository.executeWithResult(command);
    List<Order> orders = new ArrayList<>();
    while (result.next()) {
      Order town = new Order(
              result.getInt("ID"),
              result.getDate("OrderDate"),
              result.getDouble("Amount")
      );
      orders.add(town);
    }
    return orders;
  }

  @Override
  public List<Product> getOrderDetail(String username, int orderID) throws Exception {
    String command = "CALL orderDetails('" + username + "','" + orderID + "');";
    var result = repository.executeWithResult(command);
    return this.map(result);
  }

  @Override
  public List<Product> getAvailableProducts() throws Exception {
    String command = "CALL getAllAvailableProducts();";
    var result = repository.executeWithResult(command);
    return this.map(result);
  }

  @Override
  public List<Product> getProducts() throws Exception {
    String command = "CALL getAllProducts();";
    var result = repository.executeWithResult(command);
    return this.map(result);
  }

  @Override
  public void addProduct(String name, int quantity, int category, int price) throws Exception {
    String command = "CALL addNewProduct('" + name + "'," + quantity + "," + category+","+price + ");";
    repository.executeWithResult(command);
  }

  @Override
  public void deleteProduct(int product, int quantity) throws Exception {
    String command = "CALL updateProductQuantity(" + product + "," + quantity + ");";
    repository.executeWithResult(command);
  }

  @Override
  public void deleteProduct(int product) throws Exception {
    String command = "DELETE FROM product where ID = "+product;
    repository.executeWithoutResult(command);
  }

  @Override
  public void createOrder(String username, List<Product> products) throws Exception {
    try {
      this.repository.setAutoCommit(false);
      String createOrder = "SELECT createOrder('" + username + "') orderID";
      int orderId = 0;
      ResultSet result = repository.executeWithResult(createOrder);
      while (result.next()) {
        orderId = result.getInt("orderID");
      }
      for (int i = 0; i < products.size(); i++) {
        var product = products.get(i);
        String command = "CALL addOrderItem(" + orderId + "," + product.id() + "," + product.quantity() + ");";
        repository.executeWithResult(command);
      }
      this.repository.commit();
      this.repository.setAutoCommit(true);
    }
    catch (Exception e) {
      this.repository.rollback();
      this.repository.setAutoCommit(true);
      throw e;
    }
  }

  @Override
  public void updateOrder(int orderID, List<Product> products) throws Exception {
    try {
      this.repository.setAutoCommit(false);
      for (int i = 0; i < products.size(); i++) {
        var product = products.get(i);
        String command = "CALL updateOrderItem(" + orderID + "," + product.id() + "," + product.quantity() + ");";
        repository.executeWithResult(command);
      }
      this.repository.commit();
      this.repository.setAutoCommit(true);
    }
    catch (Exception e) {
      this.repository.rollback();
      this.repository.setAutoCommit(true);
      throw e;
    }
  }

  @Override
  public EmployeeRole getEmployeeRole(String username) throws Exception {
    String command = "SELECT getEmployeeRole('" + username + "') EmployeeRole;";
    ResultSet result = repository.executeWithResult(command);
    var returnResult = EmployeeRole.Regular;
    while(result.next()) {
      returnResult = EmployeeRole.role(result.getString("EmployeeRole"));
    }
    return returnResult;
  }

  @Override
  public void addEmployee(String username, String name, LocalDate date,
                          EmployeeRole role, String password) throws Exception {
    String command = "CALL createEmployee('"+name + "','" + date + "','" +
            role.toString() + "','" + username +"','"+password+"');";
    repository.executeWithResult(command);
  }

  @Override
  public void logTime(String username, LocalDate date, Time start, Time end) throws Exception {
    String command = "CALL addWorkHours('"+username + "','" + date + "','" +
            start + "','" + end +"');";
    repository.executeWithResult(command);
  }

  @Override
  public List<EmployeeWorkingHours> loggedHours() throws Exception {
    String command = "CALL getEmployeeWorkingHours();";
    var result = repository.executeWithResult(command);
    List<EmployeeWorkingHours> hours = new ArrayList<>();
    while (result.next()) {
      EmployeeWorkingHours hour = new EmployeeWorkingHours(
              result.getInt("ID"),
              result.getString("Name"),
              result.getDate("Date").toLocalDate(),
              result.getTime("LoginTime"),
              result.getTime("LogoutTime")
      );
      hours.add(hour);
    }
    return hours;
  }

  private List<Product> map(ResultSet result) throws SQLException {
    List<Product> products = new ArrayList<>();
    while (result.next()) {
      Product product = new Product(
              result.getInt("ID"),
              result.getString("ProductName"),
              result.getInt("Quantity"),
              result.getString("CategoryName"),
              result.getInt("Price")
      );
      products.add(product);
    }
    return products;
  }
}
