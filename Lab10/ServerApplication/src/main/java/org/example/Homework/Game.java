package org.example.Homework;
import java.util.*;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Timer timer;
    private TimerTask timerTask;
    private Player currentPlayer;
    private boolean gameOver;
    private int player1TimeRemaining;
    private int player2TimeRemaining;

    public Game(int size, String player1Name, String player2Name, int totalTime) {
        board = new Board(size);
        player1 = new Player(player1Name, '1');
        player2 = new Player(player2Name, '2');
        currentPlayer = player1;
        gameOver = false;
        timer = new Timer();
        player1TimeRemaining = totalTime;
        player2TimeRemaining = totalTime;
    }

    public void play(){
        startTimer();
        while (!gameOver) {

            System.out.println("Current player: " + currentPlayer.getName());
            board.printBoard();

            int row = getPlayerInput("Enter row: ");
            int col = getPlayerInput("Enter column: ");

            if (board.submitMove(row, col, currentPlayer.getSymbol())) {
                if (isWinningMove(row, col)) {
                    System.out.println("Player " + currentPlayer.getName() + " wins!");
                    gameOver = true;
                    board.printBoard();
                } else if (board.isFull()) {
                    System.out.println("It's a draw!");
                    gameOver = true;
                    board.printBoard();
                }
                System.out.println(player1.getName() + " time remaining: " + player1TimeRemaining);
                System.out.println(player2.getName() + " time remaining: " + player2TimeRemaining);

                switchPlayer();
                startTimer();
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
        stopTimer();
    }

    private int getPlayerInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextInt();
    }

    private boolean isWinningMove(int row, int col) {
        char symbol = currentPlayer.getSymbol();
        int count = 0;

        // Check horizontally
        for (int c = col - 4; c <= col + 4; c++) {
            if (c >= 0 && c < board.getSize() && board.getSymbol(row, c) == symbol) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        // Check vertically
        count = 0;
        for (int r = row - 4; r <= row + 4; r++) {
            if (r >= 0 && r < board.getSize() && board.getSymbol(r, col) == symbol) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        // Check diagonally (top-left to bottom-right)
        count = 0;
        for (int i = -4; i <= 4; i++) {
            int r = row + i;
            int c = col + i;
            if (r >= 0 && r < board.getSize() && c >= 0 && c < board.getSize() && board.getSymbol(r, c) == symbol) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        // Check diagonally (top-right to bottom-left)
        count = 0;
        for (int i = -4; i <=4; i++) {
            int r = row - i;
            int c = col + i;
            if (r >= 0 && r < board.getSize() && c >= 0 && c < board.getSize() && board.getSymbol(r, c) == symbol) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    private void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    private void startTimer() {
        if (timerTask != null) {
            timerTask.cancel();
        }

        timerTask = new TimerTask() {
            @Override
            public void run() {
                if (currentPlayer == player1) {
                    player1TimeRemaining--;
                    if (player1TimeRemaining <= 0) {
                        System.out.println("Player " + currentPlayer.getName() + " ran out of time. Game over!");
                        gameOver = true;
                        stopTimer();
                    }
                } else {
                    player2TimeRemaining--;
                    if (player2TimeRemaining <= 0) {
                        System.out.println("Player " + currentPlayer.getName() + " ran out of time. Game over!");
                        gameOver = true;
                        stopTimer();
                    }
                }
            }
        };

        timer.schedule(timerTask, 1000, 1000); // Schedule the timeout task to run every second
    }

    private void stopTimer() {
        timerTask.cancel();
        timer.cancel();
        timer.purge();
    }
}


