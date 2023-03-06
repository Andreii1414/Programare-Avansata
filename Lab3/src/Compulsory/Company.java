package Compulsory;

import java.util.ArrayList;

public class Company implements Node{
    private String name;
    private ArrayList<Person> employees;

    /**
     * Constructor
     * @param name
     */
    public Company(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    /**
     * Constructor
     * @param name
     * @param employees
     */
    public Company(String name, ArrayList<Person> employees) {
        this.name = name;
        this.employees = employees;
    }

    /**
     * Getter
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter
     * @return employees
     */
    public ArrayList<Person> getEmployees() {
        return employees;
    }

    /**
     * Setter pentru employees
     * @param employees
     */
    public void setEmployees(ArrayList<Person> employees) {
        this.employees = employees;
    }

    /**
     * Setter pentru name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metoda care adauga un angajat in lista cu angajati ai companiei
     * @param p
     */
    public void addEmployee(Person p)
    {
        employees.add(p);
    }

    /**
     * Metoda care sterge un angajat din lista cu angajati ai companiei
     * @param p
     */
    public void removeEmployee(Person p)
    {
        employees.remove(p);
    }
    @Override
    public int compareTo(Node o) {
        return this.getName().compareTo(o.getName());
    }

}
