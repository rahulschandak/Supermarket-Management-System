package model.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseOperations implements Operations {

  // server where the data-source is hosted.
  private final String server;
  // the port number
  private final int port;
  // schema name of the database
  private final String dbName;
  // the connection object
  private Connection connection;


  public DatabaseOperations() {
    this.server = "localhost";
    this.dbName = "supermarketdb";
    this.port = 3306;
  }

  @Override
  public void connect(String username, String password) throws Exception {
    Properties connectionProps = new Properties();
    connectionProps.put("user", username);
    // todo
    connectionProps.put("password", password);

    this.connection = DriverManager.getConnection("jdbc:mysql://"
                    + this.server + ":" + this.port + "/" + this.dbName
                    + "?characterEncoding=UTF-8&useSSL=false",
            connectionProps);
  }

  @Override
  public ResultSet executeWithResult(String query) throws Exception {
    Statement statement = this.connection.createStatement();
    ResultSet result = statement.executeQuery(query);
    return result;

  }

  @Override
  public void executeWithoutResult(String query) throws Exception {
    Statement statement = this.connection.createStatement();
    statement.execute(query);
  }

  @Override
  public void setAutoCommit(boolean type) throws SQLException {
    this.connection.setAutoCommit(type);
  }

  @Override
  public void commit() throws SQLException {
    this.connection.commit();
  }

  @Override
  public void rollback() throws SQLException {
    this.connection.rollback();
  }

}
