package Homework.MainPackage;

import Homework.LocationType.LocationType;

public class Location {

    private String name;
    private LocationType type;
    private double x, y;

    /**
     * constructor default
     */
    public Location() {
    }

    /**
     * Constructor
     * @param name - numele locatiei
     * @param type - tipul locatiti
     * @param x - coordonata x
     * @param y - coordonata y
     */
    public Location(String name, LocationType type, double x, double y) {
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
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
     * @return type
     */
    public LocationType getType() {
        return type;
    }

    /**
     * Setter pentru type
     * @param type
     */
    public void setType(LocationType type) {
        this.type = type;
    }

    /**
     * Getter
     * @return x
     */
    public double getX() {
        return x;
    }

    /**
     * Setter pentru x
     * @param x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Getter
     * @return y
     */
    public double getY() {
        return y;
    }

    /**
     * Setter pentru y
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return - un string cu informatii despre un obiect de tipul Location
     */
    @Override
    public String toString() {
        String info = "Location ";
        info = info + "Name: " + getName() + "; Type: " + getType().getTypeName() + "; X: " + getX() + "; Y: " + getY();
        return info;
    }

    /**
     * @param obj
     * @return true daca sunt egale, false altfel
     */
    @Override
    public boolean equals(Object obj) {

        Location location = (Location)obj;

        if(location.x == x && location.y == y && location.name == name && type == location.type)
            return true;

        return false;
    }
    
      @Override
    public int hashCode() {
        return Objects.hash(name, type, x, y);
    }
}
