package controller;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

import model.EmployeeRole;
import model.Order;
import model.Product;
import model.EmployeeWorkingHours;

public interface Features {

  // Connect to SQL
  void connect(String username, String password) throws Exception;

  // Sign in
  boolean authenticateCustomer(String username, String password) throws Exception;

  boolean authenticateEmployee(String username, String password) throws Exception;

  // register
  void register(String username, String firstname, String lastname, LocalDate dob, String password)
          throws Exception;

  List<Order> getOrderHistory(String username) throws Exception;

  List<Product> getOrderDetail(String username, int orderID) throws Exception;

  List<Product> getAllAvailableProducts() throws Exception;

  List<Product> getProducts() throws Exception;

  void createOrder(String username, List<Product> products) throws Exception;

  void updateOrder(int orderID, List<Product> products) throws Exception;

  void addProduct(String name, int quantity, int category, int price) throws Exception;

  void updateProduct(int product, int quantity) throws Exception;

  void deleteProduct(int product) throws Exception;

  EmployeeRole getEmployeeRole(String username) throws Exception;

  void addEmployee(String username, String name, LocalDate date,
                   EmployeeRole role, String password) throws Exception;

  void logTime(String username, LocalDate date, Time start, Time end) throws Exception;

  List<EmployeeWorkingHours> loggedHours() throws Exception;

}
