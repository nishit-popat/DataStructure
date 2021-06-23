import java.util.*;

public class GCDofArray {
    public static void main(String[] args) {
        int n;
        System.out.println("Enter number of elements : ");

        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();

        int a[] = new int[n];
        for(int i = 0;i<n;i++){
            a[i] = scan.nextInt();
        }

        scan.close();
        int result = a[0];
        for(int i = 1; i<n;i++){
            result = gcd(result, a[i]);

            if(result == 1){
                break;
            }
        }
        System.out.println(result);
    }

    private static int gcd(int a, int b) {
        if(a == 0){
            return b;
        }
        return gcd( b%a, a);
    }
    
}
