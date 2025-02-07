package model;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

public interface IRepository {

  void register(String username, String passwords, String firstName, String lastName, LocalDate dob)
          throws Exception;

  boolean isUserValid(String username, String password) throws Exception;

  boolean isEmployeeValid(String username, String password) throws Exception;

  List<Order> getOrderHistory(String username) throws Exception;

  List<Product> getOrderDetail(String username, int orderID) throws Exception;

  List<Product> getAvailableProducts() throws Exception;

  List<Product> getProducts() throws Exception;

  void addProduct(String name, int quantity, int category, int price) throws Exception;

  void deleteProduct(int product, int quantity) throws Exception;

  void deleteProduct(int product) throws Exception;


  void createOrder(String username, List<Product> products) throws Exception;

  void updateOrder(int orderID, List<Product> products) throws Exception;

  EmployeeRole getEmployeeRole(String username) throws Exception;

  void addEmployee(String username, String name, LocalDate date, EmployeeRole role,
                   String password) throws Exception;

  void logTime(String username, LocalDate date, Time start, Time end) throws Exception;

  List<EmployeeWorkingHours> loggedHours() throws Exception;
}
