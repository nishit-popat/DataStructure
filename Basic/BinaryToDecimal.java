package Basic;
import java.util.Scanner;

public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        scan.close();

        String s = "" + x;
        int ans = binaryToDecimal(s);
        System.out.println(ans);
    }

    private static int binaryToDecimal(String s) {
        String num = s;

        int ans = 0;

        int base = 1;
        int len = s.length();

        for(int i=len-1;i>=0;i--){
            if(num.charAt(i) == '1'){
                ans += base;
            }
            base *= 2;
        }

        return ans;
    }
}


