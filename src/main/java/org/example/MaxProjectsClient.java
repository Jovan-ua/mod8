package org.example;

public class MaxProjectsClient {
    private String id;
    private String name;

    public MaxProjectsClient(String id, String name, int projectCount) {
        this.id = id;
        this.name = name;
        this.projectCount = projectCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProjectCount() {
        return projectCount;
    }

    public void setProjectCount(int projectCount) {
        this.projectCount = projectCount;
    }

    private int projectCount;
}
