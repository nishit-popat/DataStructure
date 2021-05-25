import java.util.HashMap;

/* Given an array of N integers, and an integer K, find the number of pairs of elements in the array whose sum is equal to K.

Example 1:

Input:
N = 4, K = 6
arr[] = {1, 5, 7, 1}
Output: 2
Explanation: 
arr[0] + arr[1] = 1 + 5 = 6 
and arr[1] + arr[3] = 5 + 1 = 6. 

This better approach using map which I dont know now so understand it next time.

*/

public class CountPairsOfGivenSum {
    
    public static void main(String []args){

        int arr[] = {1, 5, 7, 1};
        int sum = 6;
        int n = arr.length;
        int no_of_pairs = countPairsWithSum(arr, n, sum);
        int no_of_pairs2 = countPairsWithSumNaiveApproach(arr, n, sum);
        System.out.println(no_of_pairs + "  " + no_of_pairs2);
    }

    private static int countPairsWithSumNaiveApproach(int[] arr, int n, int sum) {
        
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]+arr[j] == sum){
                    count++;
                    System.out.println("Pair : "+ arr[i] + "  " + arr[j]);
                }      
            }
        }
        return count;
    }

    private static int countPairsWithSum(int[] arr, int n, int sum) {
        HashMap<Integer, Integer> hm = new HashMap<>();
       for(int i=0;i<n;i++){
           if(!hm.containsKey(arr[i]))
            hm.put(arr[i],0);
            
            hm.put(arr[i], hm.get(arr[i]) + 1);
       }
       
       int twice_count = 0;
        for (int i = 0; i < n; i++) {
            if (hm.get(sum - arr[i]) != null)
                twice_count += hm.get(sum - arr[i]);
 
            if (sum - arr[i] == arr[i])
                twice_count--;
        }
 
        return twice_count / 2;
    }
}
