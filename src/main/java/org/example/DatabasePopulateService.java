package org.example;

import java.io.IOException;
import java.sql.SQLException;

public class DatabasePopulateService {
    public static void main(String[] args) {
        ReadFromFile rff = new ReadFromFile();
        Database db = new Database();
        try {
            String query = rff.readSql("C:\\Users\\user\\Desktop\\some\\dev\\mod6\\JDBCExample\\src\\main\\resources\\sql\\populate_db.sql");
            db.execute(query);
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
