import java.util.HashMap;
import java.util.Scanner;

/*
Given an array of positive integers.
Find the length of the longest sub-sequence such that elements in the subsequence are 
consecutive integers, the consecutive numbers can be in any order.
 

Example 1:

Input:
N = 7
a[] = {2,6,1,9,4,5,3}
Output:
6
Explanation:
The consecutive numbers here are 1, 2, 3, 4, 5, 6. These 6 numbers form the longest consecutive
subsquence.
Example 2:

Input:
N = 7
a[] = {1,9,3,10,4,20,2}
Output:
4
Explanation:
1, 2, 3, 4 is the longest consecutive subsequence.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Explaination video: https://youtu.be/YWXbu5uyGXs
*/
public class LongestConsequtiveSubSequence {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scan.nextInt();
        }

        scan.close();

        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int val:arr){   
            map.put(val, true);
        }
        for(int val:arr){
            if(map.containsKey(val-1)){
                map.put(val, false);
            }
        }
        int msp = 0; // max start point
        int ml = 0; // max length 
        for(int val:arr){
            if(map.get(val) == true){
                int tl = 1; // temporary length
                int tsp = val; // temporary start point

                while(map.containsKey(tsp+tl)){
                    tl++;
                }

                if(tl > ml){
                    msp = tsp;
                    ml = tl;
                }
            }
        }

        // for(int i=0;i<ml;i++){
        //     System.out.println(msp+i);
        // }
        
        System.out.println(ml);
    }
    
}
