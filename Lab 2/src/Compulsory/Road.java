package Compulsory;

public class Road {
    private int length;
    private int speedLimit;
    private RoadType type;

    public Road() { //constructor default
    }

    public Road(int length, int speedLimit, RoadType type) {
        this.length = length;
        this.speedLimit = speedLimit;
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public RoadType getType() {
        return type;
    }

    public void setType(RoadType type) {
        this.type = type;
    }

    @Override
    public String toString() {  // returneaza un string cu informatii despre un obiect de tipul Road
        String info = "Road ";
        info = info + "Length: " + getLength() + "; Speed Limit: " + getSpeedLimit() + "; Type: " + getType();
        return info;
    }
}

enum RoadType{
    Highway,
    Express,
    Country
}
