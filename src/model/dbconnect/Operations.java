package model.dbconnect;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Operations {

  void connect(String username, String password) throws Exception;

  ResultSet executeWithResult(String query) throws Exception;

  void executeWithoutResult(String query) throws Exception;

  void setAutoCommit(boolean type) throws SQLException;

  void commit() throws SQLException;

  void rollback() throws SQLException;
}
