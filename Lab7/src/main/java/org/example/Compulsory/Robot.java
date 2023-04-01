package org.example.Compulsory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public void moveRandom()
    {
        int random = new Random().nextInt(8);
        boolean[][] map = cellMap.getMap();

        switch (random)
        {
            case 0:
                if((currRow + 1) < map.length)
                        currRow = currRow + 1;
                break;
            case 1:
                if((currRow - 1) >= 0)
                        currRow = currRow - 1;
                break;
            case 2:
                if((currCol + 1) < map.length)
                        currCol = currCol + 1;
                break;
            case 3:
                if((currCol - 1) >= 0)
                        currCol = currCol - 1;
                break;
            case 4:
                if((currRow + 1) < map.length && (currCol + 1) < map.length)
                    {
                        currCol = currCol + 1;
                        currRow = currRow + 1;
                    }
                break;
            case 5:
                if((currRow + 1) < map.length && (currCol - 1) >= 0)
                    {
                        currCol = currCol - 1;
                        currRow = currRow + 1;
                    }
                break;
            case 6:
                if((currRow - 1) >= 0 && (currCol + 1) < map.length)
                    {
                        currCol = currCol + 1;
                        currRow = currRow - 1;
                    }
                break;
            case 7:
                if((currRow - 1) >= 0 && (currCol - 1) >= 0)
                    {
                        currCol = currCol - 1;
                        currRow = currRow - 1;
                    }
                break;
        }
    }

    public void run()
    {
        while(!cellMap.isMapVisited())
        {
            synchronized (this){
                moveRandom();
                if(!cellMap.isVisited(currRow, currCol))
                {
                    cellMap.visitCell(currRow, currCol, tokens = sharredMemory.extractTokens());
                    System.out.println(name + " a ales cell-ul (" + currRow + ", " + currCol + ") si token-urile " + tokens);
                }
            }
        }
    }
}
