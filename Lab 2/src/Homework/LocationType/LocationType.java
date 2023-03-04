package Homework.LocationType;

public abstract class LocationType {
    /**
     * Atribut pentru numele tipului locatiei: City, Airport, Gas Station (pentru metoda toString)
     */
    protected String typeName;
    abstract public String getTypeName();
}
