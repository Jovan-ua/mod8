package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private PreparedStatement createSt;
    private PreparedStatement readSt;
    private PreparedStatement editSt;
    private PreparedStatement deleteSt;
    private PreparedStatement maxIDSt;
    private PreparedStatement allSt;


    public ClientService(Connection connection) throws SQLException {
        createSt = connection.prepareStatement("INSERT INTO client (id, name) VALUES (SELECT MAX(id) FROM client + 1, ?)", Statement.RETURN_GENERATED_KEYS);
        maxIDSt = connection.prepareStatement("SELECT MAX(id) AS max_id FROM client");
        readSt = connection.prepareStatement("SELECT name FROM client WHERE id = ?");
        editSt = connection.prepareStatement("UPDATE client SET name = ? WHERE id = ?");
        deleteSt = connection.prepareStatement("DELETE FROM client WHERE id = ?");
        allSt = connection.prepareStatement("SELECT * FROM client");
    }

    public long create(String name) throws Exception {
        createSt.setString(1, name);
        if (name.length() < 2 || name.length() > 20) {
            throw new Exception("Wrong name value");
        }
        createSt.executeUpdate();
        long result = 0;
        ResultSet rs = maxIDSt.executeQuery();
        if (rs.next()) {
            result = rs.getLong("max_id");
            System.out.println(result);
            return result;
        } else return result;
    }

    public String getById(long id) throws Exception {
        readSt.setLong(1, id);
        if (id == 0) {
            throw new Exception("Wrong id value");
        }
        ResultSet rs = readSt.executeQuery();
        String result = "";
        if (rs.next()) {
            result = rs.getString("name");

            System.out.println(result);
        }
        return result;
    }

    public void setName(long id, String name) throws Exception {
        editSt.setString(1, name);
        editSt.setLong(2, id);
        if (name.length() < 2 || name.length() > 20) {
            throw new Exception("Wrong name value");
        }
        if (id == 0) {
            throw new Exception("Wrong id value");
        }
        editSt.executeUpdate();

    }

    public void delete(long id) throws Exception {
        deleteSt.setLong(1, id);
        if (id == 0) {
            throw new Exception("Wrong id value");
        }
        deleteSt.executeUpdate();
    }

    public List<Client> listAll() throws SQLException {
        List<Client> clients = new ArrayList<>();
        ResultSet rs = allSt.executeQuery();
        while (rs.next()) {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            clients.add(new Client(id, name));
        }
        return clients;
    }
}
