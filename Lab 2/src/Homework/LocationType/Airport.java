package Homework.LocationType;

import Homework.LocationType.LocationType;

public class Airport extends LocationType {
    private int number_of_terminals;

    /**
     * Constructor default care seteaza numele tipului "Airport"
     */
    public Airport(){
        typeName = "Airport";
    }

    /**
     * Getter
     * @return number of terminals
     */
    public int getNumber_of_terminals() {
        return number_of_terminals;
    }

    /**
     * Setter pentru number_of_terminals
     * @param number_of_terminals
     */
    public void setNumber_of_terminals(int number_of_terminals) {
        this.number_of_terminals = number_of_terminals;
    }

    /**
     * @return - numele tipului de locatie = "Airport"
     */
    @Override
    public String getTypeName() {
        return typeName;
    }
}
