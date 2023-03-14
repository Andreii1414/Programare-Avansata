package org.example.Compulsory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        /**
         * Crearea unui LinkedList cu studenti folosind stream-uri
         */

            List<Student> students =  Stream.of(
                new Student("S0", Stream.of(new Project("P0"), new Project("P1"), new Project("P2")).collect(Collectors.toList())),
                new Student("S1", Stream.of(new Project("P0"), new Project("P1")).collect(Collectors.toList())),
                new Student("S2", Stream.of(new Project("P0")).collect(Collectors.toList()))
            ).collect(Collectors.toCollection(LinkedList::new));


        /**
         * Crearea unui Treeset folosind stream-uri
         */

        Set<Project> projects = Stream.of(
                new Project("P0"),
                new Project("P1"),
                new Project("P2")
                ).collect(Collectors.toCollection(TreeSet::new));


        /**
         * Sortare si printare
         */
        students.stream().sorted(Comparator.comparing(Student::getName)).forEach(student -> System.out.println(student.toString()));
        projects.stream().sorted(Comparator.comparing(Project::getName)).forEach(project -> System.out.println(project.toString()));
    }
}