package Basic;
import java.util.*;
public class ArmStrongNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        scan.close();

        int sum = 0;
        int temp = x;
        int length = 0;
        while(temp != 0){
            temp = temp/10;
            length++;
        }

        temp = x;


        while(temp != 0){
            int c = temp % 10;
            sum += Math.pow(c, length);
            temp = temp/10;
        }

       if(sum == x){
           System.out.println("Number is Armstrong");
       }
       else{
           System.out.println("Number is not Armstrong");
       }

    }
    
}
