package Homework.RoadType;

public class Country extends RoadType {

    /**
     * @return - numele tipului de drum = "Country"
     */
    @Override
    public String getTypeName() {
        return typeName;
    }

    /**
     * Constructor default care seteaza numele tipului "Country"
     */
    public Country()
    {
        typeName = "Country";
    }
}
