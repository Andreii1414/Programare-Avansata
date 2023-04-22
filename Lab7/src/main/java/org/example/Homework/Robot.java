package org.example.Homework;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Robot implements Runnable{
    private String name;
    SharedMemory sharredMemory;
    private int currRow;
    private int currCol;
    private CellMap cellMap;
    private List<Integer> tokens;

    public Robot(String name, int currRow, int currCol, SharedMemory sharredMemory, CellMap cellMap) {
        this.sharredMemory = sharredMemory;
        this.name = name;
        this.currRow = currRow;
        this.currCol = currCol;
        this.cellMap = cellMap;
        tokens = new ArrayList<>();
    }

    /**
     * BFS - viziteaza toate celulele adiacente nevizitate
     */
    public void run() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{currRow, currCol});

        while (!queue.isEmpty()) {
            int[] position = queue.remove();
            int row = position[0];
            int col = position[1];
             if (!cellMap.isVisited(row, col)) {
                 List<Integer> t = new ArrayList<>();
                 cellMap.visitCell(row, col, t = sharredMemory.extractTokens());
                 System.out.println(name + " a ales cell-ul (" + row + ", " + col + ") si token-urile " + t);
                 for(Integer i : t) {
                     tokens.add(i);
                 }

                 if (row > 0 && !cellMap.isVisited(row-1, col)) {
                     queue.add(new int[]{row-1, col});
                 }
                 if (row < cellMap.getMap().length - 1 && !cellMap.isVisited(row+1, col)) {
                     queue.add(new int[]{row+1, col});
                 }
                 if (col > 0 && !cellMap.isVisited(row, col-1)) {
                     queue.add(new int[]{row, col-1});
                 }
                 if (col < cellMap.getMap().length - 1 && !cellMap.isVisited(row, col+1)) {
                     queue.add(new int[]{row, col+1});
                 }
             }
         }
    }

    public void printInfo()
    {
        System.out.println("Robotul " + name + " a extras " + tokens.size() + " tokeni ");
    }


}
