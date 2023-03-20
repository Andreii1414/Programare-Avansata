package org.example.Homework;

import java.util.*;
import java.util.stream.Collectors;

public class Problem {
    private List<Student> studentList;
    private Set<Project> projectSet;

    /**
     * Constructor
     * @param studentList
     * @param projectSet
     */
    public Problem(List<Student> studentList, Set<Project> projectSet) {
        this.studentList = studentList;
        this.projectSet = projectSet;
    }

    public Problem() {
    }

    /**
     * Getter
     * @return studentList
     */
    public List<Student> getStudentList() {
        return studentList;
    }

    /**
     * Setter pentru studentList
     * @param studentList
     */
    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    /**
     * Getter
     * @return projectSet
     */
    public Set<Project> getProjectSet() {
        return projectSet;
    }

    /**
     * Setter pentru projectSet
     * @param projectSet
     */
    public void setProjectSet(Set<Project> projectSet) {
        this.projectSet = projectSet;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "studentList=" + studentList +
                ", projectSet=" + projectSet +
                '}';
    }

    /**
     * Returneaza o lista cu studentii care au mai putine preferinte decat media
     * @return students with lower pref than average
     */
    public List<Student> getStudentsWithLowerPref()
    {
        double total = 0;
        for(Student student: studentList)
            total += student.getProjectList().size();

        double average = total/studentList.size();

        return studentList.stream().filter(student -> student.getProjectList().size() < average)
                .collect(Collectors.toList());
    }

    /**
     * Algoritm greedy care asigneaza proiectele studentilor parcurgand studentii si listele lor in ordinea ascendenta
     * a numarului de preferinte
     * @return map care contine studentii si proiectele asignate
     */
    public Map<Student, Project> assignProjects (){

        Collections.sort(studentList, Comparator.comparing(Student::getProjectListSize));

        Map<Student, Project> studentProjectMap = new HashMap<>();
        Set<Project> unassignedProjects = new TreeSet<>(projectSet);

        for(Student student : studentList)
        {
            for(Project project : student.getProjectList())
            {
                if(unassignedProjects.contains(project))
                {
                    studentProjectMap.put(student,project);
                    unassignedProjects.remove(project);
                    break;
                }
            }
        }

        return studentProjectMap;
    }
}
