package Basic;
import java.util.Scanner;

/*
A number n is said to be Abundant Number if sum of all the proper divisors of the number 
denoted by sum(n) is greater than the value of the number n. 
And the difference between these two values is called the abundance. 
*/

public class AbundantNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        scan.close();

        System.out.println(isAbundant(x));
    }

    private static boolean isAbundant(int x) {
        int sum = 1; // 1 is already there for all numbers
        for (int i = 2; i <= Math.sqrt(x); i++) {

            if (x % i == 0) {
                // If divisors are equal,take only
                // one of them
                if (x / i == i) {
                    sum = sum + i;
                }

                // Otherwise take both
                else {
                    sum = sum + i;
                    sum = sum + (x / i);
                }
            }
        }

        if(sum > x){
            return true;
        }

        return false;
    }

}
