import java.util.HashSet;
import java.util.Set;

/* 
    Given an array arr[] of size n, find the first repeating element. 
    The element should occurs more than once and the index of its first occurrence should be the smallest.
Example 1:
Input: n = 7
    arr[] = {1, 5, 3, 4, 3, 5, 6}
Output: 2
Explanation: 
5 is appearing twice and its first appearence is at index 2 
which is less than 3 whose first occuring index is 3.

Example 2:
Input: n = 4
    arr[] = {1, 2, 3, 4}
Output: -1
Explanation: 
All elements appear only once so 
answer is -1.

*/

public class FirstRepeatingElement{
    public static void main(String[] args) {
        int arr1[] = {1, 5, 3, 4, 3, 5, 6};
        int n = arr1.length;

        int arr2[] = {1, 2, 3, 4};
        int n2 = arr2.length;

        System.out.println(firstRepeated(arr1, n));
        System.out.println(firstRepeated(arr2, n2));
        
        }

    private static int firstRepeated(int[] arr, int n) {
        Set<Integer> s = new HashSet<>();
        int ans = -1;
        for(int i=(n-1); i>=0; i--){
            if(s.contains(arr[i]))
                ans = i+1;
            else 
                s.add(arr[i]);
        }
        return ans;
    }
}