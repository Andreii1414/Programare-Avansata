package Homework.MainPackage;

import Homework.LocationType.Airport;
import Homework.LocationType.City;
import Homework.LocationType.GasStation;
import Homework.MainPackage.BestRouteInstance;
import Homework.RoadType.Country;
import Homework.RoadType.Express;
import Homework.RoadType.Highway;


import java.util.ArrayList;

public class Homework {
    public static void main(String[] args) {
        Location location2 = new Location("Otopeni", new Airport(), 25.12235,10.85435);
        Location location1 = new Location("Iasi", new City(), 70.151726,30.12368);
        Location location3 = new Location("Omv Constanta", new GasStation(), 40.1517226,50.123568);

        Road road2 = new Road(20,130, new Highway(),"A2", location1, location2);
        Road road1 = new Road(30,100, new Country(), "N1", location1, location3);
        Road road3 = new Road(120,100, new Express(), "N1", location2, location3); //length > distanta euclidiana

        /**
         * Exemplu de instanta valida
         */
        ArrayList<Location> locations1 = new ArrayList<Location>();
        locations1.add(location1);
        locations1.add(location2);
        ArrayList<Road> roads1 = new ArrayList<Road>();
        roads1.add(road1);
        roads1.add(road2);
        BestRouteInstance bestRouteInstance = new BestRouteInstance(locations1, roads1);
        System.out.println(bestRouteInstance.isValid());

        /**
         * Exemplu de instanta invalida
         */
       ArrayList<Location> locations2 = new ArrayList<Location>();
        locations2.add(location1);
        locations2.add(location2);
        locations2.add(location3);
        ArrayList<Road> roads2 = new ArrayList<Road>();
        roads2.add(road1);
        roads2.add(road2);
        roads2.add(road3);
        BestRouteInstance bestRouteInstance2 = new BestRouteInstance(locations2, roads2);
        System.out.println(bestRouteInstance2.isValid());
    }
}
