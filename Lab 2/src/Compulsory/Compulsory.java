package Compulsory;

public class Compulsory {
    public static void main(String[] args) {

        //Creez o locatie si adaug informatii folosind setterele
        Location l1 = new Location();
        l1.setName("Otopeni");
        l1.setType(LocationType.Airport);
        l1.setX(44.569331056);
        l1.setY(26.084332996);

        Location l2 = new Location("Iasi", LocationType.City, 47.151726, 27.587914);
        Location l3 = new Location("OMV Constanta", LocationType.GasStation, 44.179249, 28.649940);

        //Creez un drum si adaug informatii folosind setterele
        Road r1 = new Road();
        r1.setLength(150);
        r1.setSpeedLimit(130);
        r1.setType(RoadType.Highway);

        Road r2 = new Road(500, 90, RoadType.Country);
        Road r3 = new Road(300, 120, RoadType.Express);

        System.out.println(l1.toString());
        System.out.println(l2.toString());
        System.out.println(l3.toString());

        System.out.println(r1.toString());
        System.out.println(r2.toString());
        System.out.println(r3.toString());

    }
}
