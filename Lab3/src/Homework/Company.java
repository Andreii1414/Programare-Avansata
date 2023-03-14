package Homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Company implements Node {
    private String name;
    private int importance;
    private ArrayList<Person> employees = new ArrayList<>();
    private Map<Node, RelationshipType> relationshipMap = new HashMap<>();

    /**
     * Constructor
     * @param name
     * @param employees
     * @param relationshipMap
     */
    public Company(String name, ArrayList<Person> employees, Map<Node, RelationshipType> relationshipMap) {
        this.name = name;
        this.employees = employees;
        this.relationshipMap = relationshipMap;
    }

    /**
     * Constructor
     * @param name
     */
    public Company(String name) {
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

    /**
     * Getter
     * @return relationshipMap
     */
    @Override
    public Map<Node, RelationshipType> getRelationshipMap() {
        return relationshipMap;
    }

    /**
     * Setter pentru relationshipMap
     * @param relationshipMap
     */
    public void setRelationshipMap(Map<Node, RelationshipType> relationshipMap) {
        this.relationshipMap = relationshipMap;
    }

    /**
     * Getter
     * @return importance
     */
    public int getImportance() {
        return importance;
    }

    /**
     * Setter pentru importance
     * @param importance
     */
    public void setImportance(int importance) {
        this.importance = importance;
    }

    @Override
    public int compareTo(Node o) {
        return this.getName().compareTo(o.getName());
    }

    /**
     * Adaug o relatie in ambele sensuri (adica daca adaug relatie intre Person1 si Company1 adaug relatia
     * si la map-ul din Company si la map-ul din Person)
     * @param node
     * @param relationshipType
     */
    public void addRelationship(Node node, RelationshipType relationshipType)
    {
        relationshipMap.put(node,relationshipType);
        if(relationshipType == RelationshipType.PERSON_TO_PERSON)
            node.getRelationshipMap().put(this, RelationshipType.PERSON_TO_PERSON);
        else node.getRelationshipMap().put(this, RelationshipType.PERSON_TO_COMPANY);
    }

}
