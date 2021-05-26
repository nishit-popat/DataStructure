import java.util.LinkedHashMap;
import java.util.Map;

/*
Find the first non-repeating element in a given array arr of N integers.
Note: Array consists of only positive and negative integers and not zero.

Example 1:
Input : arr[] = {-1, 2, -1, 3, 2}
Output : 3
Explanation:
-1 and 2 are repeating whereas 3 is 
the only number occuring once.
Hence, the output is 3. 
 
Example 2:
Input : arr[] = {1, 1, 1}
Output : 0
*/

public class NonRepeatingElement {

    public static void main(String[] args) {
        
        int arr[] = 
        {-1, -17, -12, 8, 16, -17, -13, -14, -3, -6, -5, -11, -10, -12, -5, 19, -17, -5, -1, 12};
        int n = arr.length;

        //int arr2[] = { 1, 1, 1};
        //int n2 = arr2.length;
        
        System.out.println(firstNonRepeating(arr,n));
        
        
    }

    private static int firstNonRepeating(int[] arr, int n) {
        /* The Major Difference between the HashMap and LinkedHashMap is the ordering of the elements. 
        The LinkedHashMap provides a way to order and trace the elements. 
        Comparatively, the HashMap does not support the ordering of the elements. In LinkedHashMap, 
        if we iterate an element, we will get a key in the order in which the elements were inserted. */
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], 1);
            }
            else{
                map.put(arr[i], map.get(arr[i])+1);
            }
        }
        System.out.println(map.toString());

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return 0;
    }
    
}
