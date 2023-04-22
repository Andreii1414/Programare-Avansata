package org.example.Homework;

import java.sql.Time;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        int size = 20;
        int nrRobots = 2;

        SharedMemory sharedMemory = new SharedMemory(size);
        CellMap cellMap = new CellMap(size);
        Thread[] threadList = new Thread[nrRobots];
        int[][] robotPosition = new int[size][size];
        Arrays.asList(robotPosition, 0);

        Robot[] robotList = new Robot[nrRobots];

        for(int i = 0; i < nrRobots; i++)
        {
            int row;
            int col;

            do{
                row = new Random().nextInt(size);
                col = new Random().nextInt(size);
                if(robotPosition[row][col] != 1)
                    robotPosition[row][col] = 1;
            }while(robotPosition[row][col] != 1);

            robotPosition[row][col] = 1;

            robotList[i] = new Robot("Robot " + i, row, col, sharedMemory, cellMap);
        }

        for(int i = 0 ; i < nrRobots; i++)
        {
            threadList[i] = new Thread(robotList[i]);
           // threadList[i].start();
        }

        RobotManager robotManager = new RobotManager(threadList);
        Scanner scanner = new Scanner(System.in);
        boolean firstTimeAll = true;
        boolean firstTimeList[] = new boolean[nrRobots];
        Arrays.fill(firstTimeList, true);

        Timekeeper timekeeper = new Timekeeper(200, cellMap, robotList);
        timekeeper.start();

        while (!cellMap.isMapVisited())
        {
            String cmd = scanner.nextLine();
            String split[] = cmd.split(" ", 2);
            String split3[] = cmd.split(" ", 3);

            if(split[0].equals("pauseall") && split.length == 1)
            {
                System.out.println("Toti robotii au fost opriti.");
                robotManager.pauseAll();
            }
            else if(split[0].equals("pauseall") && split.length == 2)
            {
                System.out.println("Toti robotii au fost opriti pentru " + split[1] + " secunde");
                robotManager.pauseAllForTime(Integer.parseInt(split[1]));
            }
            else if(split3[0].equals("pause") && split3.length == 2) {
                System.out.println("Robotul cu indexul " + split3[1] + " a fost oprit");
                robotManager.pauseOne(Integer.parseInt(split3[1]));
            }
            else if(split3[0].equals("pause") && split3.length == 3)
            {
                System.out.println("Robotul cu indexul " + split3[1] + " a fost oprit pentru " + split3[2] + " secunde");
                robotManager.pauseOneForTime(Integer.parseInt(split3[1]), Integer.parseInt(split3[2]));
            }
            else if(split[0].equals("startall"))
            {
                System.out.println("Toti robotii au fost porniti");
                if(firstTimeAll){
                    robotManager.startAllFirstTime();
                    firstTimeAll = false;
                    Arrays.fill(firstTimeList, false);
                }
                else robotManager.startAll();
            }
            else if(split[0].equals("start") && split.length == 2)
            {
                System.out.println("Robotul cu indexul " + split3[1] + " a fost pornit");
                if(firstTimeList[Integer.parseInt(split[1])])
                {
                    firstTimeList[Integer.parseInt(split[1])] = false;
                    robotManager.startFirstTime(Integer.parseInt(split[1]));
                }
                else robotManager.startOne(Integer.parseInt(split[1]));
            }
        }

    }
}