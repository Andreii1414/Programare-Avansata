package org.example.Homework;

public class Timekeeper extends Thread{
    private int timeLimit;
    private CellMap map;
    public boolean timeUp;
    public Robot[] robots;

    public Timekeeper(int timeLimit, CellMap map, Robot[] robots) {
        this.timeLimit = timeLimit;
        this.timeUp = false;
        this.map = map;
        this.robots = robots;
        setDaemon(true);
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();

        while(!timeUp && !map.isMapVisited())
        {
            long currentTime = (System.currentTimeMillis() - start)/1000;

            if(currentTime >= timeLimit)
            {
                System.out.println("Timpul limita a fost depasit. Explorarea este oprita.");
                timeUp = true;
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Durata explorarii: " + (System.currentTimeMillis() - start)/1000 + " secunde");
        for(int i = 0; i < robots.length; i++)
        {
            robots[i].printInfo();
        }
        System.exit(0);
    }
}
