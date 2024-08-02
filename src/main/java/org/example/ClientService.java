package org.example;

import java.sql.*;

public class ClientService {
    private PreparedStatement createSt;
    private PreparedStatement readSt;
    private PreparedStatement editSt;
    private PreparedStatement deleteSt;
    private PreparedStatement maxIDSt;


    public ClientService(Connection connection) throws SQLException {
        createSt = connection.prepareStatement("INSERT INTO client (id, name) VALUES (SELECT MAX(id) FROM client + 1, ?)", Statement.RETURN_GENERATED_KEYS);
        maxIDSt = connection.prepareStatement("SELECT MAX(id) AS max_id FROM client");
        readSt = connection.prepareStatement("SELECT name FROM client WHERE id = ?");
    }

    public long create(String name) throws SQLException {
        createSt.setString(1, name);
        createSt.executeUpdate();
        long result = 0;
        ResultSet rs = maxIDSt.executeQuery();
        if (rs.next()) {
            result = rs.getLong("max_id");
            System.out.println(result);
            return result;
        } else return result;
    }

    public String getById(long id) throws SQLException {
        readSt.setLong(1, id);
        ResultSet rs = readSt.executeQuery();
        String result = "";
        if (rs.next()) {
            result = rs.getString("name");

            System.out.println(result);
        }
        return result;
    }

}
