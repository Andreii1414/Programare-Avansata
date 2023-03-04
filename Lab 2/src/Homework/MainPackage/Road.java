package Homework.MainPackage;

import Homework.RoadType.RoadType;

public class Road {
    private int length;

    private String name;
    private int speedLimit;
    private RoadType type;

    private Location from, to;

    /**
     * constructor default
     */
    public Road() {
    }

    /**
     * Constructor
     * @param length - lungimea drumului
     * @param speedLimit - limita de viteza
     * @param type - tipul de drum
     * @param name - numele drumului
     */
    public Road(int length, int speedLimit, RoadType type, String name, Location from, Location to) {
        this.length = length;
        this.speedLimit = speedLimit;
        this.type = type;
        this.name = name;
        this.from = from;
        this.to = to;
    }

    /**
     * Getter
     * @return length
     */
    public int getLength() {
        return length;
    }

    /**
     * Setter pentru length
     * @param length
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Getter
     * @return speedLimit
     */
    public int getSpeedLimit() {
        return speedLimit;
    }

    /**
     * Setter pentru speedLimit
     * @param speedLimit
     */
    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    /**
     * Getter
     * @return type
     */
    public RoadType getType() {
        return type;
    }

    /**
     * Setter pentru type
     * @param type
     */
    public void setType(RoadType type) {
        this.type = type;
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
     * @return from
     */
    public Location getFrom() {
        return from;
    }

    /**
     * Setter pentru from
     * @param from
     */
    public void setFrom(Location from) {
        this.from = from;
    }

    /**
     * Getter
     * @return to
     */
    public Location getTo() {
        return to;
    }

    /**
     * Setter pentru to
     * @param to
     */
    public void setTo(Location to) {
        this.to = to;
    }

    /**
     * @return - un string cu informatii despre un obiect de tipul Road
     */
    @Override
    public String toString() {
        String info = "Road ";
        info = info + "Length: " + getLength() + "; Speed Limit: " + getSpeedLimit() + "; Type: " + getType().getTypeName();
        return info;
    }

    /**
     * @param obj
     * @return true daca sunt egale, false altfel
     */
    @Override
    public boolean equals(Object obj) {
        Road road = (Road)obj;

        if(road.speedLimit == speedLimit && road.length == length && type == road.type && name == road.name)
            return true;

        return false;
    }
}
