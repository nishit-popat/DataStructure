import java.util.Scanner;

/*
Given an array Arr that contains N integers (may be positive, negative or zero). 
Find the product of the maximum product subarray.

Example 1:

Input:
N = 5
Arr[] = {6, -3, -10, 0, 2}
Output: 180
Explanation: Subarray with maximum product
is 6, -3, -10 which gives product as 180.
Example 2:

Input:
N = 6
Arr[] = {2, 3, 4, 5, -1, 0}
Output: 120
Explanation: Subarray with maximum product
is 2, 3, 4, 5 which gives product as 120.

*/

public class MaxProductSubArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        System.out.println(maxProduct(arr, n));
    }

    private static long maxProduct(int[] arr, int n) {
        long overallProduct = (long)arr[0]; // to keep track of overall maximum product
        long currentMaxProduct = (long)arr[0]; // to keep track of current maximum product
        long currentMinProduct = (long)arr[0]; // to keep track of current minimum product

        for (int i = 1; i < n; i++) {
            // if current element is 0 then we have to start again and all our previous current will 
            // have to initialize from 1.
            if (arr[i] == 0) {
                currentMaxProduct = 1;
                currentMinProduct = 1;
                continue;
            }

            // here temp will save current max because it will gonna change after maximum of three call
            long temp = currentMaxProduct;
            // find current max from arr[i], arr[i]*currentMaxProduct and arr[i]*currentMinProduct
            currentMaxProduct = maximumOfThree(arr[i], arr[i] * currentMaxProduct, 
            arr[i] * currentMinProduct);
            // find current min from arr[i], arr[i]*temp(current Max) and arr[i]*currentMinProduct
            currentMinProduct = minimumOfThree(arr[i], arr[i] * temp, arr[i] * currentMinProduct);

            // if overallProduct is less then currentMaxProduct then update it
            if(overallProduct < currentMaxProduct){
                overallProduct = currentMaxProduct;
            }

        }
        // return the overall product
        return overallProduct;
    }

    // return maximum of three numbers
    private static long maximumOfThree(long i, long j, long k) {

        if (i >= j && i >= k) {
            return i;
        } else if (j > k) {
            return j;
        } else {
            return k;
        }
        
    }

    // return minimum of three numbers
    private static long minimumOfThree(long i, long j, long k) {
        if (i < j && i < k) {
            return i;
        } else if (j < k) {
            return j;
        } else {
            return k;
        }
    }
}