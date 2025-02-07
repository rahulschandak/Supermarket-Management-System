package controller;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

import model.EmployeeRole;
import model.IRepository;
import model.Product;
import model.dbconnect.DatabaseOperations;
import model.EmployeeWorkingHours;
import model.dbconnect.Operations;
import model.Order;
import model.Repository;
import view.View;

public class Controller implements Features {

  private final View view;
  private final Operations repository;
  private final IRepository model;

  public Controller(View view) {
    this.view = view;
    this.repository = new DatabaseOperations();
    this.model = new Repository(this.repository);
    this.view.addFeatures(this);
  }

  @Override
  public void connect(String username, String password) throws Exception {
    this.repository.connect(username, password);
  }

  @Override
  public boolean authenticateCustomer(String username, String password) throws Exception {
    return this.model.isUserValid(username, password);
  }

  @Override
  public boolean authenticateEmployee(String username, String password) throws Exception {
    return this.model.isEmployeeValid(username, password);
  }

  @Override
  public void register(String username, String firstname, String lastname, LocalDate dob,
                       String password) throws Exception {
    this.model.register(username, password, firstname, lastname, dob);
  }

  @Override
  public List<Order> getOrderHistory(String username) throws Exception {
    return this.model.getOrderHistory(username);
  }

  @Override
  public List<Product> getOrderDetail(String username, int orderID) throws Exception {
    return this.model.getOrderDetail(username, orderID);
  }

  @Override
  public List<Product> getAllAvailableProducts() throws Exception {
    return this.model.getAvailableProducts();
  }

  @Override
  public List<Product> getProducts() throws Exception {
    return this.model.getProducts();
  }

  @Override
  public void createOrder(String username, List<Product> products) throws Exception {
    this.model.createOrder(username, products);
  }

  @Override
  public void updateOrder(int orderID, List<Product> products) throws Exception {
    this.model.updateOrder(orderID, products);
  }

  @Override
  public void addProduct(String name, int quantity, int category, int price) throws Exception {
    this.model.addProduct(name, quantity, category, price);
  }

  @Override
  public void updateProduct(int product, int quantity) throws Exception {
    this.model.deleteProduct(product, quantity);
  }

  @Override
  public void deleteProduct(int product) throws Exception {
    this.model.deleteProduct(product);
  }

  @Override
  public EmployeeRole getEmployeeRole(String username) throws Exception {
    return this.model.getEmployeeRole(username);
  }

  @Override
  public void addEmployee(String username, String name, LocalDate date, EmployeeRole role,
                          String password) throws Exception {
    this.model.addEmployee(username, name, date, role, password);
  }

  @Override
  public void logTime(String username, LocalDate date, Time start, Time end) throws Exception {
    this.model.logTime(username, date, start, end);
  }

  @Override
  public List<EmployeeWorkingHours> loggedHours() throws Exception {
    return this.model.loggedHours();
  }
}
