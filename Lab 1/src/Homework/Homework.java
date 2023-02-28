package Homework;
public class Homework {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

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

        int[][] latinSquare = new int[n][n];

        //explicatie pt n = 5
        int k1 = 0;
        for(int i = 0; i < n; i++)
        {
            int k2 = 0;
            for(int j = n - 1; j >= 0; j--){
                if(j + 1 - k1 <= 0){ //2. in loc de 0 de mai jos pun 5, in loc de -1 pun 4, etc
                    latinSquare[i][j] = n - k2;
                    k2++;
                }
                else latinSquare[i][j] = j + 1 - k1;  //1. Linia 0: 1 2 3 4 5; Linia 1: *0* 1 2 3 4 ; Linia 2: *-1* *0* 1 2 3;...
            }
            k1++;
        }

      if(n < 100)
      {
          for(int i = 0; i < n; i++) //printez matricea
          {
              for(int j = 0; j < n; j++)
                  System.out.print(latinSquare[i][j]);
              System.out.println();
          }
      }

        for(int i = 0; i < n; i++) {
            String line = new String("");
            String col = new String("");
            for (int j = 0; j < n; j++) { //concatenez linia i, respectiv coloana i
                line = line + latinSquare[i][j];
                col = col + latinSquare[j][i];
            }
            if (n < 100) { //pentru n >= 100 nu mai printez liniile si coloanele concatenate
                System.out.println("Line " + i + " :" + line);
                System.out.println("Column: " + i + " :" + col);
            }
        }

        long end = System.currentTimeMillis();
        System.out.println((end - start)+ " milliseconds");
    }
}
