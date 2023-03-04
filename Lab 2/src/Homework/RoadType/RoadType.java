package Homework.RoadType;

public abstract class RoadType {
    /**
     * Atribut pentru numele tipului drumului: City, Airport, Gas Station (pentru metoda toString)
     */
    protected String typeName;
    abstract public String getTypeName();
}
