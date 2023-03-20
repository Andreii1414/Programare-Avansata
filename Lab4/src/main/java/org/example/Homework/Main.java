package org.example.Homework;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //Exemplu enunt
        List<Student> studentList =  Stream.of(
                new Student("S0", Stream.of(new Project("P0"), new Project("P1"), new Project("P2")).collect(Collectors.toCollection(TreeSet::new))),
                new Student("S1", Stream.of(new Project("P0"), new Project("P1")).collect(Collectors.toCollection(TreeSet::new))),
                new Student("S2", Stream.of(new Project("P0")).collect(Collectors.toCollection(TreeSet::new)))
        ).collect(Collectors.toCollection(LinkedList::new));

        Set<Project> projectSet = Stream.of(
                new Project("P0"),
                new Project("P1"),
                new Project("P2")
        ).collect(Collectors.toCollection(TreeSet::new));

        /*
        Use a third-party library in order to generate random fake names for students and projects.
        */
        //-------------------------------------------------------------------------------------------------------------
        Faker faker = new Faker();

        Set<Project> projects = new TreeSet<>();
        for (int i = 0; i < 7; i++) {
            projects.add(new Project(faker.app().name()));
        }

        List<Student> students = new ArrayList<>();
        for(int i = 0; i < 7;i++) {
            Set<Project> projectListForStudentI = new TreeSet<>();
            int projectNr = faker.random().nextInt(1, projects.size());
            for(int j = 0; j < projectNr; j++)
            {
                int random = faker.random().nextInt(projects.size());
                Project[] projectArray = projects.toArray(new Project[0]);
                projectListForStudentI.add(projectArray[random]);
            }
            students.add(new Student(faker.name().fullName(), projectListForStudentI));
        }
        //-------------------------------------------------------------------------------------------------------------

        /*
        Using Java Stream API, write a query that display all the students that have
        a number of preferences lower than the average number of preferences.
        */
        //-------------------------------------------------------------------------------------------------------------
        //Problem problem = new Problem(studentList, projectSet);
        Problem problem = new Problem(students, projects);
        List<Student> fewerPref = problem.getStudentsWithLowerPref();
        fewerPref.stream().forEach(project -> System.out.println(project.toString()));
        //-------------------------------------------------------------------------------------------------------------

        // System.out.println();
        // students.stream().sorted().forEach(student -> System.out.println(student));
        // System.out.println();

        Map<Student, Project> assignedProjects = problem.assignProjects();
        for (Map.Entry<Student, Project> values : assignedProjects.entrySet()) {
            Project project = values.getValue();
            Student student = values.getKey();
            System.out.println(student.getName() + ": " + project.getName());
        }

    }
}