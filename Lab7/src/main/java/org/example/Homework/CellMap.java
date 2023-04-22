package org.example.Homework;

import java.util.List;

public class CellMap {
    private int n;
    private boolean[][] map;
    private int[][][] tokens;

    public CellMap(int n) {
        this.n = n;
        tokens = new int[n][n][n];
        map = new boolean[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                map[i][j] = false;
    }

    public boolean isVisited(int i, int j)
    {
        return map[i][j];
    }

    public boolean isMapVisited()
    {
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(!map[i][j])
                    return false;
        return true;
    }

    public synchronized void visitCell(int i, int j, List<Integer> tokenList)
    {
        map[i][j] = true;
        for(int k = 0; k < tokenList.size(); k++)
        {
            tokens[i][j][k] = tokenList.get(k);
        }
    }

    public boolean[][] getMap() {
        return map;
    }

    public void printTokens()
    {
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("(" + i + ", " + j + "): ");
                for (int k = 0; k < n; k++) {
                    System.out.print(tokens[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
