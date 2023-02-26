package Compulsory;

public class Location {
    private String name;
    private LocationType type;
    private double x, y;

    public Location() { //constructor default
    }

    public Location(String name, LocationType type, double x, double y) {
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocationType getType() {
        return type;
    }

    public void setType(LocationType type) {
        this.type = type;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {  // returneaza un string cu informatii despre un obiect de tipul Location
        String info = "Location ";
        info = info + "Name: " + getName() + "; Type: " + getType() + "; X: " + getX() + "; Y: " + getY();
        return info;
    }
}

enum LocationType{
    City,
    Airport,
    GasStation
}
