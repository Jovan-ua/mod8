package org.example;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        DatabaseQueryService queryService = new DatabaseQueryService();
        List<LongestProject> longestProjects = queryService.findLongestProject();
        for (LongestProject element : longestProjects) {
            System.out.println("Project ID: " + element.getName() + ", Month Count: " + element.getMonthCount());
        }
        List<MaxProjectsClient> maxProjectsClients = queryService.findMaxProjectsClient();
        for (MaxProjectsClient element : maxProjectsClients) {
            System.out.println("Project ID: " + element.getId() + ", Name: " + element.getName() + ", Project_Count: " + element.getProjectCount());
        }
        List<MaxSalaryWorker> maxSalaryWorkers = queryService.findMaxSalaryWorker();
        for (MaxSalaryWorker element : maxSalaryWorkers) {
            System.out.println("Name: " + element.getName() + ", Salary: " + element.getSalary());
        }
        List<YoungestEldestWorker> youngestEldestWorkers = queryService.findYoungestEldestWorker();
        for (YoungestEldestWorker element : youngestEldestWorkers) {
            System.out.println("Type: " + element.getType() + ", Name: " + element.getName() + ", Birthday: " + element.getBirthday() );
        }
        List<ProjectPrices> projectPrices = queryService.printProjectPrices();
        for (ProjectPrices element : projectPrices) {
            System.out.println("Name: " + element.getName() + ", Price: " + element.getPrice());
        }
    }
}
