package Homework;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Person 1", LocalDate.of(1990, 12, 1));
        Person person2 = new Person("Person 2", LocalDate.of(1980, 02, 15));
        String[] programmingLanguages = {"C++", "Java"};
        Person person3 = new Programmer("Person 3", LocalDate.of(1998, 06, 25),
                programmingLanguages);
        Person person4 = new Designer("Person 4", LocalDate.of(1999, 05, 20),
                "Web designer");

        Company company1 = new Company("Company 1");
        Company company2 = new Company("Company 2");

        person1.addRelationship(person2, RelationshipType.PERSON_TO_PERSON);
        person1.addRelationship(person3, RelationshipType.PERSON_TO_PERSON);
        person3.addRelationship(person4, RelationshipType.PERSON_TO_PERSON);
        person4.addRelationship(person1, RelationshipType.PERSON_TO_PERSON);
        person1.addRelationship(company1, RelationshipType.PERSON_TO_COMPANY);
        person2.addRelationship(company1, RelationshipType.PERSON_TO_COMPANY);
        company2.addRelationship(person4, RelationshipType.PERSON_TO_COMPANY);
        //Person 1 - 4
        //Person 2 - 2
        //Person 3 - 2
        //Person 4 - 3
        //Company 1 - 2
        //Company 2 - 1

        Network network = new Network();
        network.addNode(person1);
        network.addNode(person2);
        network.addNode(person3);
        network.addNode(person4);
        network.addNode(company1);
        network.addNode(company2);

        network.computeImportanceAllNodes();
        List<Node> nodes = network.getByImportance();
        for (Node node : nodes) {
            System.out.println(node.getName() + " - Importance: " + node.getImportance());
        }
    }
}
