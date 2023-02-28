package Bonus;

public class Ex1Bonus {
    public static void main(String[] args) {

        if(args.length != 1) //verific ca exista un singur argument (n)
        {
            System.out.println("Niciun argument/Mai mult de un argument.");
            return;
        }

        int n;

        try{ //validez argumentul (daca e intreg)
            n = Integer.parseInt(args[0]);
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            return; //nu e intreg
        }

        int[][] adjacencyMatrix = new int[n][n];

        adjacencyMatrix[0][n-1] = 1; //legatura intre nodul 0 si n-1 (nodul anterior al nodului 0)
        adjacencyMatrix[n-1][0] = 1; //legatura intre nodul n-1 si 0 (nodul urmator al nodului n-1) + graf neorientat

        for(int i = 0; i < n - 1; i++)
        {
            adjacencyMatrix[i][i+1] = 1; //fac legaturi intre nodul curent si nodul anterior si nodul curent si nodul urmator
            adjacencyMatrix[i+1][i] = 1; //- graf neorientat
        }

        int[][] An = adjacencyMatrix;

        System.out.println("A = ");
        Print(adjacencyMatrix, n);

        for(int i = 2; i <= n; i++) // calculez A2...An
        {
            An = mul(adjacencyMatrix,An, n);
            System.out.println("A ^ " + i + "=");
            Print(An, n);
        }
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

    public static int[][] mul(int[][] A, int[][] B, int n)
    {
        int[][] C = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                for(int k = 0; k < n; k++)
                {
                    C[i][j] = C[i][j] + A[i][k] * B[k][j];
                }
        return C;
    }
}
