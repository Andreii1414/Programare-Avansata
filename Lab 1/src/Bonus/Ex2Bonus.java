package Bonus;

public class Ex2Bonus {
    public static void main(String[] args) {

        if(args.length != 2)
        {
            System.out.println("Niciun argument/Mai mult de un argument.");
            return;
        }

        int n;
        int m;

        try{
            n = Integer.parseInt(args[0]);
            m = Integer.parseInt(args[1]);
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            return;
        }

        if (n <= 0 || n % 2 != 0) {
            System.out.println("Combinatie invalida de noduri si grade.");
            return;
        }

        int[][] adjacencyMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= m/2; j++) {
                int rightNeighbor = i + j;
                int leftNeighbor = i - j;

                if (rightNeighbor >= n) {
                    rightNeighbor -= n;
                }

                if (leftNeighbor < 0) {
                    leftNeighbor += n;
                }

                adjacencyMatrix[i][rightNeighbor] = 1;
                adjacencyMatrix[i][leftNeighbor] = 1;

                if(m % 2 != 0)
                {
                    int secondNeighbor = i + n / 2;
                    if (secondNeighbor >= n) {
                        secondNeighbor -= n;
                    }
                    adjacencyMatrix[i][secondNeighbor] = 1;
                }

            }
        }
        Print(adjacencyMatrix, n);
    }

    public static void Print(int[][] A, int n)
    {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
