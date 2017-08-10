package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import properties.LoadFrameworkProp;

public class DBConnection {
	public Connection connection = null;
	public ResultSet resultSet = null;
	public Statement statement = null;
	
	public Connection getDBConnection(){
		LoadFrameworkProp prop = new LoadFrameworkProp();
		try {
		Class.forName(prop.getDbDriverUrl());
		connection = DriverManager.
				getConnection(prop.getDbConnectionUrl()+":@"+prop.getDbHostName()+":"+prop.getDbPortNo()+":"+prop.getDbName()
						,prop.getDbUserName(),prop.getDbPassword());
		} catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		System.out.println("connection: "+connection);
		return connection;
	}
	
	
	public ResultSet executeQuery(String query) {         
        try {
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
             ResultSet.CONCUR_READ_ONLY);
               resultSet = statement.executeQuery(query);                   
  } catch (SQLException e) {
      e.printStackTrace();
  }                        
        return resultSet;
 }
}
