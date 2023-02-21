public class Class {
    public static void main(String args[]) {
      System.out.println("Hello World!");
      String languages[] = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
      int n = (int) (Math.random() * 1_000_000);
      n *= 3;
      n += bin2Dec(10101);
      n += Integer.parseInt("FF", 16);
      n *= 6;
      
      while(n > 9)
        {
            int sum = 0;
            int n2 = n;
            while(n2 != 0)
            {
                sum += n2%10;
                n2/=10;
            }
            n = sum;
        }
    
     System.out.println("Willy-nilly, this semester I will learn " + languages[n]);
     }
    
    public static int bin2Dec(int bin)
    {
        int d = 0, n = 0;
        while(true)
        {
            if(bin == 0)
                break;
            else {
                d += (bin%10) * Math.pow(2, n);
                bin = bin/10;
                n++;
            }
            
        }
        return(d);
    }

}