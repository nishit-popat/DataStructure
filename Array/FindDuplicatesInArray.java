import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/*  
Given an array a[] of size N which contains elements from 0 to N-1, 
you need to find all the elements occurring more than once in the given array.

Example 1:

Input:
N = 4
a[] = {0,3,1,2}
Output: -1
Explanation: N=4 and all elements from 0
to (N-1 = 3) are present in the given
array. Therefore output is -1.
Example 2:

Input:
N = 5
a[] = {2,3,1,2,3}
Output: 2 3 
Explanation: 2 and 3 occur more than once
in the given array.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).
*/

public class FindDuplicatesInArray {

    public static void main(String []args){
        int arr[] = {2, 3, 1, 2, 3};
        int n = arr.length;

        ArrayList<Integer> ans = new ArrayList<>();
        ans = findDuplicates(arr, n);
        System.out.println(ans.toString());
    }

    private static ArrayList<Integer> findDuplicates(int[] arr, int n) {

        ArrayList<Integer> list = new ArrayList<>();

        Map<Integer, Integer> m = new HashMap<>(); //define Hashmap
        for(int i=0;i<arr.length;i++){
            // if we have don't have arr[i] as a key in the map then add arr[i] as a key and 0 as its values
            if(!m.containsKey(arr[i])){
                m.put(arr[i], 0);
            }

            // update the key value pair of arr[i], first retrieve old value using m.get(arr[i]) and then add 1 to it
            m.put(arr[i], m.get(arr[i])+1);
        }
        //System.out.println(m.toString());

        // Traversing through hashmap and if freq is greater than 1 then add it to ArrayList
        for (Map.Entry<Integer, Integer> i : m.entrySet()){
            if(i.getValue() > 1){
                list.add(i.getKey());
            }
        }
        return list;
    }
    
}
