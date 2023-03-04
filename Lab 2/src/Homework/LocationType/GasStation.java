package Homework.LocationType;

import Homework.LocationType.LocationType;

public class GasStation extends LocationType {
    private int gas_price;

    /**
     * Constructor default care seteaza numele tipului "Gas Station"
     */
    public GasStation(){
        typeName = "Gas Station";
    }

    /**
     * @return - numele tipului de locatie = "Gas Station"
     */
    @Override
    public String getTypeName() {
        return typeName;
    }

    /**
     * Getter
     * @return gasPrice
     */
    public int getGas_price() {
        return gas_price;
    }

    /**
     * Setter pentru gas price
     * @param gas_price
     */
    public void setGas_price(int gas_price) {
        this.gas_price = gas_price;
    }
}
