package Basic;
import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long x = scan.nextInt();
        scan.close();

        long ans = 0;
        long temp = x;
        while (temp != 0) {
            long c = temp % 10;
            ans = ans + factorial(c);
            temp = temp / 10;
        }

        if(ans == x){
            System.out.println("Strong Number");
        }
        else{
            System.out.println("Not a Strong Number");
        }

    }

    private static long factorial(long x) {
        if (x == 0 || x == 1) {
            return 1;
        }

        long fnm1 = factorial(x - 1);
        return x * fnm1;
    }

}
