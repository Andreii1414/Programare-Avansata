package Homework;

import Homework.Person;

import java.time.LocalDate;
import java.util.Date;

public class Programmer extends Person {

    private String[] programmingLanguages;

    /**
     * Constructor
     *
     * @param name
     * @param birthDate
     */
    public Programmer(String name, LocalDate birthDate, String[] programmingLanguages) {
        super(name, birthDate);
        this.programmingLanguages = programmingLanguages;
    }

    public String[] getProgrammingLanguages() {
        return programmingLanguages;
    }

    public void setProgrammingLanguages(String[] programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }
}
