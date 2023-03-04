package Homework.RoadType;

public class Highway extends RoadType {
    /**
     * @return numele tipului de drum = "Highway"
     */
    @Override
    public String getTypeName() {
        return typeName;
    }

    /**
     * Constructor default care seteaza numele tipului "Highway"
     */
    public Highway() {
        typeName = "Highway";
    }
}
