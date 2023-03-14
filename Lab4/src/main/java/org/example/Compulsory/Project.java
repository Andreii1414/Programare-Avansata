package org.example.Compulsory;

public class Project implements Comparable<Project> {

    private String name;

    /**
     * Constructor
     * @param name
     */
    public Project(String name) {
        this.name = name;
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
     * @param o the object to be compared.
     * @return less than/equal to/greater than (int)
     */
    @Override
    public int compareTo(Project o) {
        return this.name.compareTo(o.name);
    }

    /**
     * Ovveride toString
     * @return String care contine informatii despre Student
     */
    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                '}';
    }
}
