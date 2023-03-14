package Homework;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Person implements Node {
    private String name;
    private LocalDate birthDate;
    private int importance;
    private Map<Node, RelationshipType> relationshipMap = new HashMap<>();

    /**
     * Constructor
     *
     * @param name
     * @param birthDate
     */
    public Person(String name, LocalDate birthDate, Map<Node, RelationshipType> relationshipMap) {
        this.name = name;
        this.birthDate = birthDate;
        this.relationshipMap = relationshipMap;
    }

    /**
     * Constructor
     * @param name
     * @param birthDate
     */
    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
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
     * @return birthDate
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Setter pentru birthDate
     * @param birthDate
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Getter
     * @return relationshipMap
     */
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
     * si la map-ul lui Company1 si la map-ul lui Person1)
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
