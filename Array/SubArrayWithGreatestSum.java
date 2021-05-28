/* Given an array arr of N integers. Find the contiguous sub-array with maximum sum.

Example 1:
Input:
N = 5
arr[] = {1,2,3,-2,5}
Output:
9
Explanation:
Max subarray sum is 9
of elements (1, 2, 3, -2, 5) which 
is a contiguous subarray.

Example 2:
Input:
N = 4
arr[] = {-1,-2,-3,-4}
Output:
-1
Explanation:
Max subarray sum is -1 
of element (-1)


This can be solved using brute force method by checking all the possible sub arrays 
but its time complexity will be O(N^2).

So here I have solved using Kadane's algorithm which will solve it in O(N) time.
Youtube link : https://www.youtube.com/watch?v=VMtyGnNcdPw
*/


import java.util.Scanner;

public class SubArrayWithGreatestSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();

        System.out.println(maxArraySum(arr,n));
    }

    private static int maxArraySum(int[] arr, int n) {
        int curSum = arr[0];  //current sum will track of current sum at current element
        int overallSum = arr[0]; // it will store overall best sum
        for(int i=1;i<n;i++){
            // if current sum is positive then current element will benefit to join them
            if(curSum >= 0){
                curSum += arr[i];
            }
            // if current sum is negative then current element will not join them
            else{
                curSum = arr[i];
            }

            // it will keep track of best current sum and store it in overall sum
            if(overallSum < curSum){
                overallSum = curSum;
            }
        }
        return overallSum;
    }
    
}
