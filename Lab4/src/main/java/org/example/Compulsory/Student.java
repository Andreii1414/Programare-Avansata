package org.example.Compulsory;

import java.util.List;

public class Student implements Comparable<Student> {

    private String name;
    private List<Project> projectList;

    /**
     * Constructor
     * @param name
     * @param projectList
     */
    public Student(String name, List<Project> projectList) {
        this.name = name;
        this.projectList = projectList;
    }

    /**
     * Getter
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter pentru name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter
     * @return projectList
     */
    public List<Project> getProjectList() {
        return projectList;
    }

    /**
     * Setter pentru projectList
     * @param projectList
     */
    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    /**
     * @param o the object to be compared.
     * @return less than/equal to/greater than (int)
     */
    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }

    /**
     * Ovveride toString
     * @return String care contine informatii despre Student
     */
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", projectList=" + projectList +
                '}';
    }
}
