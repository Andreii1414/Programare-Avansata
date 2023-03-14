package org.example.Compulsory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        /**
         * Crearea studentilor folosind stream-uri
         */
        Student s0 = new Student("S0", Stream.of(new Project("P0"), new Project("P1"), new Project("P2")).collect(Collectors.toList()));
        Student s1 = new Student("S1", Stream.of(new Project("P0"), new Project("P1")).collect(Collectors.toList()));
        Student s2 = new Student("S2", Stream.of(new Project("P0")).collect(Collectors.toList()));

        /**
         * Crearea unui LinkedList cu studenti folosind stream-uri
         */
        List<Student> students =  Stream.of(
                s0,
                s1,
                s2
        ).collect(Collectors.toCollection(LinkedList::new));

        /*
            List<Student> students =  Stream.of(
                new Student("S0", Stream.of(new Project("P0"), new Project("P1"), new Project("P2")).collect(Collectors.toList())),
                new Student("S1", Stream.of(new Project("P0"), new Project("P1")).collect(Collectors.toList())),
                new Student("S2", Stream.of(new Project("P0")).collect(Collectors.toList()))
            ).collect(Collectors.toCollection(LinkedList::new));
         */

        /**
         * Crearea proiectelor
         */

        Project p0 = new Project("P0");
        Project p1 = new Project("P1");
        Project p2 = new Project("P2");

        /**
         * Crearea unui Treeset folosind stream-uri
         */

        Set<Project> projects = Stream.of(
                    p0,
                    p1,
                    p2
        ).collect(Collectors.toCollection(TreeSet::new));

        /*
              Set<Project> projects = Stream.of(
                   new Project("P0");,
                   new Project("P1");,
                   new Project("P2");
              ).collect(Collectors.toCollection(TreeSet::new));
         */

        /**
         * Sortare si printare
         */
        students.stream().sorted(Comparator.comparing(Student::getName)).forEach(student -> System.out.println(student.toString()));
        projects.stream().sorted(Comparator.comparing(Project::getName)).forEach(project -> System.out.println(project.toString()));
    }
}