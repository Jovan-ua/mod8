package org.example;

import org.flywaydb.core.Flyway;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        // Module 8
        Flyway flyway = Flyway.configure().dataSource("jdbc:h2:~/test", "sa", "").load();
        flyway.migrate();
        ClientService cs = new ClientService(DriverManager.getConnection("jdbc:h2:~/test", "sa", ""));
        cs.create("Petro");
        cs.getById(3);
        cs.setName(5, "Ivan");
        cs.delete(6);
        cs.listAll();

//        DatabaseQueryService queryService = new DatabaseQueryService();
//        List<LongestProject> longestProjects = queryService.findLongestProject();
//        for (LongestProject element : longestProjects) {
//            System.out.println("Project ID: " + element.getName() + ", Month Count: " + element.getMonthCount());
//        }
//        List<MaxProjectsClient> maxProjectsClients = queryService.findMaxProjectsClient();
//        for (MaxProjectsClient element : maxProjectsClients) {
//            System.out.println("Project ID: " + element.getId() + ", Name: " + element.getName() + ", Project_Count: " + element.getProjectCount());
//        }
//        List<MaxSalaryWorker> maxSalaryWorkers = queryService.findMaxSalaryWorker();
//        for (MaxSalaryWorker element : maxSalaryWorkers) {
//            System.out.println("Name: " + element.getName() + ", Salary: " + element.getSalary());
//        }
//        List<YoungestEldestWorker> youngestEldestWorkers = queryService.findYoungestEldestWorker();
//        for (YoungestEldestWorker element : youngestEldestWorkers) {
//            System.out.println("Type: " + element.getType() + ", Name: " + element.getName() + ", Birthday: " + element.getBirthday() );
//        }
//        List<ProjectPrices> projectPrices = queryService.printProjectPrices();
//        for (ProjectPrices element : projectPrices) {
//            System.out.println("Name: " + element.getName() + ", Price: " + element.getPrice());
//        }
    }
}
