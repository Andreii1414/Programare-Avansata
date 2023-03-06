package Compulsory;

public class Person implements Node{
    private String name;
    private Company company;
    private String specialization;

    /**
     * Constructor
     * @param name
     */
    public Person(String name) {
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
     * Setter pentru name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter
     * @return company
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Setter pentru company
     * @param company
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * Getter
     * @return specialization
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * Setter pentru specialization
     * @param specialization
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public int compareTo(Node o) {
        return this.getName().compareTo(o.getName());
    }
}
