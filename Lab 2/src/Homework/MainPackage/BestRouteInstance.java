package Homework.MainPackage;

import java.util.ArrayList;

public class BestRouteInstance {
    private ArrayList<Location> locations;
    private ArrayList<Road> roads;

    /**
     * Constructor
     * @param roads - lista cu drumuri
     * @param locations - lista cu locatii
     */
    public BestRouteInstance(ArrayList<Location> locations, ArrayList<Road> roads) {
        this.locations = locations;
        this.roads = roads;
    }

    /**
     * Constructor default
     */
    public BestRouteInstance(){
    }

    /**
     * Getter
     * @return locations
     */
    public ArrayList<Location> getLocations() {
        return locations;
    }

    /**
     * Setter pentru locations
     * @param locations
     */
    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    /**
     * Getter
     * @return roads
     */
    public ArrayList<Road> getRoads() {
        return roads;
    }

    /**
     * Setter pentru roads
     * @param roads
     */
    public void setRoads(ArrayList<Road> roads) {
        this.roads = roads;
    }

    /**
     * Metoda care verifica daca o instanta a problemei este valida
     * @return true/false daca instanta este valida/invalida
     */

    public boolean isValid()
    {
        /**
         * Verific daca doua locatii sunt la fel parcurgand lista cu locatii o data si apoi inca o data incepand cu
         * locatia curenta + 1, verificand daca gasesc doua locatii la fel. In caz afirmativ, returnez false;
         */
        for(int i = 0; i < this.getLocations().size(); i++)
        {
            for(int j = i + 1; j < this.getLocations().size() - 1; j++)
                if(this.getLocations().get(i).equals(this.getLocations().get(j)))
                    return false;
        }
        /**
         * Verific daca doua drumuri sunt la fel parcurgand lista cu drumuri o data si apoi inca o data incepand cu drumul
         * curent + 1, verificand daca gasesc doua drumuri la fel. In caz afirmativ, returnez false;
         */
        for(int i = 0; i < this.getRoads().size(); i++)
        {
            for(int j = i + 1; j < this.getRoads().size() - 1; j++)
                if(this.getRoads().get(i).equals(this.getRoads().get(j)))
                    return false;
        }
        /**
         * Verific daca lungimea fiecarui drum este < decat distanta euclidiana dintre locatiile sale
         */
        for(int i = 0; i <this.getRoads().size(); i++)
        {
            Road road = this.getRoads().get(i);
            //distanta euclidiana: sqrt((x1 - x2)^2 + (y1 - y2)^2)
            double distance = Math.sqrt(Math.pow(road.getFrom().getX()-road.getTo().getX(), 2) +
                    Math.pow(road.getFrom().getY() - road.getTo().getY(), 2));
            if(road.getLength() > distance) //daca lungimea drumului este mai mare decat distanta euclidiana
            {
                return false;
            }
        }
        return true;
    }
}
