import java.util.Scanner;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // number of disks
        int t1 = scan.nextInt(); // name of tower 1
        int t2 = scan.nextInt(); // name of tower 2
        int t3 = scan.nextInt(); // name of tower 3
        scan.close();

        toh(n, t1, t2, t3);
    }

    private static void toh(int n, int t1, int t2, int t3) {

        if(n==0){
            return;
        }

        toh(n-1, t1, t3, t2);
        System.out.println(n + "[ " +t1 + " -> " + t2 + "]");  // will print the instructions to move n-1 disks from t1 to t3 using t2(*)
        toh(n-1, t3, t2, t1);

    }
    
}
