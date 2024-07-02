package org.example;

import java.io.IOException;
import java.sql.*;

public class Database {
    private  static  final String DB_URL = "jdbc:h2:~/test1";
    private  static  final String DB_UserName = "user";
    private  static  final String DB_Password = "";
    private Connection connection;

    public Database() {
        try {
            initialize();
        } catch (SQLException | IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void initialize() throws SQLException, IOException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        connection = DriverManager.getConnection(DB_URL, DB_UserName, DB_Password);
    }
    public void execute(String str) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate(str);

    }
    public ResultSet executeRS(String str) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(str);

        return resultSet;
    }

}
