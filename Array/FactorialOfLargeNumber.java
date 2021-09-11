import java.math.BigInteger;

// This problem can be solved in one or two ways both the methods are given here.
public class FactorialOfLargeNumber {
    public static void main(String[] args) {
        //This is remaining   
        factorial(100);
        System.out.println(FactorialUsingBigInteger(90));
    }

    public static void factorial(int n){
        int MAX_SIZE = 200;
        int res[] = new int[MAX_SIZE];

        //initialize result
        res[0] = 1;
        int res_size = 1;

        //Apply simple factorial formula
        for(int i=2;i<=n;i++){
            res_size = multiply(i, res, res_size);
        }

        System.out.println("Factorial of a given number is : ");
        for(int i = res_size - 1; i>=0;i--){
            System.out.print(res[i]);
        }
    }

    // This function multiplies x with the number represented by res[i].
    // res_size is the size of res
    // This function returns the new value of res_size
    public static int multiply(int x, int res[], int res_size){
        int carry = 0;

        // one by one multiply x with individual digits
        for(int i=0; i<res_size; i++){
            int prod = res[i] * x + carry;
            res[i] = prod % 10;
            carry = prod/10;
        } 

        // put carry in res and increase the result size
        while(carry != 0){
            res[res_size] = carry%10;
            carry = carry/10;
            res_size++;
        }

        return res_size;
    }

    public static BigInteger FactorialUsingBigInteger(int N){
        BigInteger f = new BigInteger("1");

        // multiply f with 2, 3, 4, ..., N
        for(int i=2; i<=N; i++){
            f=f.multiply(BigInteger.valueOf(i));
        }

        return f;
    }
}
