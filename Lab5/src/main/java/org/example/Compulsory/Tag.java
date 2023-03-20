package org.example.Compulsory;

public class Tag {
    private String name;
    private String value;

    /**
     * Constructor
     * @param name
     * @param value
     */
    public Tag(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public Tag() {
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
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * Setter pentru value
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
