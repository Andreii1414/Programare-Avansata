package org.example.Homework;

public class Board {
    private char[][] board;
    int size;
    public Board(int size) {
        this.size = size;
        board = new char[size][size];
        initialize();
    }

    public void initialize(){
        for(int i = 0; i < size; i ++)
            for(int j = 0; j < size; j++)
                board[i][j] = '-';
    }

    public boolean submitMove(int row, int col, char symbol){
        if(row < 0 || row >= size || col < 0 || col >=size)
            return false;
        if(board[row][col] != '-')
            return false;
        board[row][col] = symbol;
        return true;
    }

    public char getSymbol(int row, int col){
        return board[row][col];
    }

    public int getSize() {
        return size;
    }

    public void printBoard(){
        System.out.print("  ");
        for (int col = 0; col < size; col++) {
            System.out.print(col + " ");
        }
        System.out.println();
        for (int row = 0; row < size; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < size; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    public boolean isFull(){
        for (int row = 0; row < size; row++)
          for (int col = 0; col < size; col++)
            if (board[row][col] == '-')
                return false;
        return true;
    }
}
