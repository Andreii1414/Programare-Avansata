package Homework.LocationType;

import Homework.LocationType.LocationType;

public class City extends LocationType {
    private long population;
    private float area;

    /**
     * Constructor default care seteaza numele tipului "City"
     */
    public City(){
        typeName = "City";
    }

    /**
     * Getter
     * @return population
     */
    public long getPopulation() {
        return population;
    }

    /**
     * Setter pentru population
     * @param population
     */
    public void setPopulation(long population) {
        this.population = population;
    }

    /**
     * Getter
     * @return area
     */
    public float getArea() {
        return area;
    }

    /**
     * Setter pentru area
     * @param area
     */
    public void setArea(float area) {
        this.area = area;
    }

    /**
     * @return - numele tipului de locatie = "City"
     */
    @Override
    public String getTypeName() {
        return typeName;
    }
}
