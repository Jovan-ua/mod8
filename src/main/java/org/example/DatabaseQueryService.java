package org.example;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private Database database = new Database();

    public  List<LongestProject> findLongestProject() throws IOException {
        List<LongestProject> result = new ArrayList<>();
        String query = new ReadFromFile().readSql("C:\\Users\\user\\Desktop\\some\\dev\\mod6\\JDBCExample\\src\\main\\resources\\sql\\find_longest_project.sql");
        try {
            ResultSet resultSet = database.executeRS(query);
            while (resultSet.next()) {
                String name = resultSet.getString("ID");
                int monthCount = resultSet.getInt("MONTH_COUNT");
                result.add(new LongestProject(name, monthCount));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    return result;
    }
    public  List<MaxProjectsClient> findMaxProjectsClient() throws IOException {
        List<MaxProjectsClient> result = new ArrayList<>();
        String query = new ReadFromFile().readSql("C:\\Users\\user\\Desktop\\some\\dev\\mod6\\JDBCExample\\src\\main\\resources\\sql\\find_max_projects_client.sql");
        try {
            ResultSet resultSet = database.executeRS(query);
            while (resultSet.next()) {
                String id = resultSet.getString("ID");
                String name = resultSet.getString("NAME");
                int projectCount = resultSet.getInt("PROJECT_COUNT");
                result.add(new MaxProjectsClient(id, name, projectCount));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    public  List<MaxSalaryWorker> findMaxSalaryWorker() throws IOException {
        List<MaxSalaryWorker> result = new ArrayList<>();
        String query = new ReadFromFile().readSql("C:\\Users\\user\\Desktop\\some\\dev\\mod6\\JDBCExample\\src\\main\\resources\\sql\\find_max_salary_worker.sql");
        try {
            ResultSet resultSet = database.executeRS(query);
            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                int salary = resultSet.getInt("SALARY");
                result.add(new MaxSalaryWorker(name, salary));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    public  List<YoungestEldestWorker> findYoungestEldestWorker() throws IOException {
        List<YoungestEldestWorker> result = new ArrayList<>();
        String query = new ReadFromFile().readSql("C:\\Users\\user\\Desktop\\some\\dev\\mod6\\JDBCExample\\src\\main\\resources\\sql\\find_youngest_eldest_workers.sql");
        try {
            ResultSet resultSet = database.executeRS(query);
            while (resultSet.next()) {
                String type = resultSet.getString("TYPE");
                String name = resultSet.getString("NAME");
                String rawDate = resultSet.getString("BIRTHDAY");
                result.add(new YoungestEldestWorker(type, name, LocalDate.parse(rawDate)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    public  List<ProjectPrices> printProjectPrices() throws IOException {
        List<ProjectPrices> result = new ArrayList<>();
        String query = new ReadFromFile().readSql("C:\\Users\\user\\Desktop\\some\\dev\\mod6\\JDBCExample\\src\\main\\resources\\sql\\print_project_prices.sql");
        try {
            ResultSet resultSet = database.executeRS(query);
            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                Integer price = resultSet.getInt("PRICE");
                result.add(new ProjectPrices(name, price));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

}
