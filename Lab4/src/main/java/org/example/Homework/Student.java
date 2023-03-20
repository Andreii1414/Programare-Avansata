package org.example.Homework;

import java.util.List;
import java.util.Set;

public class Student implements Comparable<Student> {

    private String name;
    private Set<Project> projectList;

    /**
     * Constructor
     * @param name
     * @param projectList
     */
    public Student(String name, Set<Project> projectList) {
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
    public Set<Project> getProjectList() {
        return projectList;
    }

    public int getProjectListSize(){return getProjectList().size();}

    /**
     * Setter pentru projectList
     * @param projectList
     */
    public void setProjectList(Set<Project> projectList) {
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
