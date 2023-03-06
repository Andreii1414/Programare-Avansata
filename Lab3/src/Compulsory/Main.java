package Compulsory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Person 1");
        Person person2 = new Person("Person 2");
        Person person3 = new Person("Person 3");
        Person person4 = new Person("Person 4");
        Person person5 = new Person("Person 5");

        Company company1 = new Company("Company 1");
        Company company2 = new Company("Company 2");

        company1.addEmployee(person1);
        company1.addEmployee(person2);
        company1.addEmployee(person3);

        company2.addEmployee(person4);
        company2.addEmployee(person5);

        List<Node> nodes = new ArrayList<>();
        nodes.add(person1);
        nodes.add(person2);
        nodes.add(person3);
        nodes.add(person4);
        nodes.add(person5);
        nodes.add(company1);
        nodes.add(company2);

        for(int i = 0; i < nodes.size();i++)
            System.out.println(nodes.get(i).getName());
    }


}
