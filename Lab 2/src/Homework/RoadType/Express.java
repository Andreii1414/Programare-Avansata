package Homework.RoadType;

public class Express extends RoadType {

    /**
     * @return - numele tipului de drum = "Express"
     */
    @Override
    public String getTypeName() {
        return typeName;
    }

    /**
     * Constructor default care seteaza numele tipului "Express"
     */
    public Express()
    {
        typeName = "Express";
    }

}
