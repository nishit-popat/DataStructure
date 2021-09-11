import java.util.HashSet;

/*
Given an array of positive and negative numbers. 
Find if there is a subarray (of size at-least one) with 0 sum.

Example 1
Input:
5
4 2 -3 1 6
Output: 
Yes

Explanation: 
2, -3, 1 is the subarray 
with sum 0.

Example 2:
Input:
5
4 2 0 1 6
Output: 
Yes

*/

public class SubArrayWithZeroSum {
    public static void main(String[] args) {

        int arr[] = {4, 2, -3, 1, 6};
        int arr2[] = {4, 2, 0, 1, 6};
        int n = arr.length;
        int n2 = arr2.length;


        //Using naive approach in N^2 time
        System.out.println(findSumIfZeroNaive(arr, n));
        System.out.println(findSumIfZeroNaive(arr2, n2));
        
        // Using efficient approach of prefix array and hashset
        System.out.println(findSumIfZero(arr,n));
        System.out.println(findSumIfZero(arr2,n2));

    }

    // This method uses naive approach to find sum if it is zero
    private static boolean findSumIfZeroNaive(int[] arr, int n) {
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i+1; j < n; j++){
             	sum += arr[j];
             	if(sum == 0){
             		return true;
             	}
            }
        }	
        return false;
    }

    // This method use the HashSet and prefix array to solve this in O(n)
    private static boolean findSumIfZero(int[] arr, int n) {
        int sum = arr[0];
        HashSet<Integer> hs = new HashSet<>();
        hs.add(arr[0]);
        for(int i=1;i<n;i++){
            sum += arr[i]; // this sum will contain the sum of elements to left of the current element + current element
            if(sum == 0 || hs.contains(sum) || arr[i]==0){
                return true;
            }
            else{
                hs.add(sum);
            }
        }
        return false;
    }
    
}
