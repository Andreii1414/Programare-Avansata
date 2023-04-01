package org.example.Compulsory;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        int size = 4;
        int nrRobots = 2;

        SharedMemory sharedMemory = new SharedMemory(size);
        CellMap cellMap = new CellMap(size);
        List<Thread> threadList = new ArrayList<>();
        int[][] robotPosition = new int[size][size];
        Arrays.asList(robotPosition, 0);

        for(int i = 1; i <= nrRobots; i++)
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

            Robot robot = new Robot("Robot " + i, row, col, sharedMemory, cellMap);
            Thread thread = new Thread(robot);
            thread.start();
            threadList.add(thread);
        }

        for(Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        cellMap.printTokens();
    }
}