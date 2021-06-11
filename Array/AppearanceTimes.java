import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Given an array arr[] of size N and an element k. 
The task is to find all elements in array that appear more than n/k times.

Example 1:

Input:
N = 8
arr[] = {3,1,2,2,1,2,3,3}
k = 4
Output: 2
Explanation: In the given array, 3 and 2 are the only elements that appears 
more than n/k times.

Example 2:
Input:
N = 4
arr[] = {2,3,3,2}
k = 3
Output: 2
Explanation: In the given array, 3 and 2 are the only elements that appears more 
than n/k times. So the count of elements are 2.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).
*/

public class AppearanceTimes {
    
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();

        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scan.nextInt();
        }


        scan.close();
        int ans = countOccurence(arr,n,k);
        
        System.out.println(ans);
        
    }

    // this function returns the answer
    private static int countOccurence(int[] arr, int n, int k) {

        Map<Integer, Integer> mp = new HashMap<>();

        // by using hashmap we can store frequency of each element in an array
        for(int i = 0;i<n;i++){
            int x = arr[i];
            if(mp.containsKey(x)){
                int temp = mp.get(x);
                mp.put(x, temp+1);
            }
            else{
                mp.put(x, 1);
            }
        }
        int count = 0;
        // every time frequency of elemnent exceeded from n/k we will increase counter and return counter
        for(Map.Entry<Integer, Integer> mapElement : mp.entrySet()){
            int val = mapElement.getValue();
            if(val > (n/k)){
                count++;
            }
        }
        return count;
    }
}
