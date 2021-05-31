import java.util.ArrayList;
import java.util.Stack;

/*
Given an array arr[] of size N and an integer K. 
Find the maximum for each and every contiguous subarray of size K.

Example 1:
Input:
N = 9, K = 3
arr[] = 1 2 3 1 4 5 2 3 6
Output: 
3 3 4 5 5 5 6 
Explanation: 
1st contiguous subarray = {1 2 3} Max = 3
2nd contiguous subarray = {2 3 1} Max = 3
3rd contiguous subarray = {3 1 4} Max = 4
4th contiguous subarray = {1 4 5} Max = 5
5th contiguous subarray = {4 5 2} Max = 5
6th contiguous subarray = {5 2 3} Max = 5
7th contiguous subarray = {2 3 6} Max = 6
*/

public class SlidingWindowMax {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
        int n = arr.length;
        int k = 3; // size of subarray
        ArrayList<Integer> ans = maxSubArrayElement(arr, n, k);
        System.out.println(ans.toString());

    }

    private static ArrayList<Integer> maxSubArrayElement(int[] arr, int n, int k) {
        // if size of array is less then given size of sub array
        if (n < k) {
            System.out.println("here n is less then k");
            return null;
        } else {
            
            Stack<Integer> st = new Stack<>();

            //First we will find the next greater element of every element
            // Here we will store index of next greater element in nge array
            int nge[] = new int[n];
            nge[n - 1] = n; // last element has no greater element to his right side so here we will put n
            st.push(n - 1); // in the stack also we will push indexes 

            for (int i = (n - 2); i >= 0; i--) {
                // -a+
                // first pop until smaller elements available in stack
                while (st.size() > 0 && arr[st.peek()] <= arr[i]) {
                    st.pop();
                }

                // then store index in nge array
                if (st.isEmpty())
                    nge[i] = arr.length;
                else
                    nge[i] = st.peek();

                // then push current index    
                st.push(i);
            }

            int j=0;

            // Now we will use this nge array to determine max element in particular window
            ArrayList<Integer> res = new ArrayList<>();

            for(int i=0;i<=(n-k);i++){
                //enter the loop to find the maximum of window starting at i
                if(j < i){
                    j=i;
                }

                while(nge[j] < i+k){
                    j = nge[j];
                }
                res.add(arr[j]);
            }
            return res;
        }
        
    }

}
