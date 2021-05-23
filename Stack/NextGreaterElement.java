import java.util.Arrays;
import java.util.Stack;

/* 1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are required to "next greater element on the right" for all elements of array
4. Input and output is handled for you.

"Next greater element on the right" of an element x is defined as the first element to right of x having value greater than x.
Note -> If an element does not have any element on it's right side greater than it, consider -1 as it's "next greater element on right"
e.g.
for the array [2 5 9 3 1 12 6 8 7]
Next greater for 2 is 5
Next greater for 5 is 9
Next greater for 9 is 12
Next greater for 3 is 12
Next greater for 1 is 12
Next greater for 12 is -1
Next greater for 6 is 8
Next greater for 8 is -1
Next greater for 7 is -1

Solution Explaination : https://www.youtube.com/watch?v=rSf9vPtKcmI&list=TLGGkwOOlYxenicyMzA1MjAyMQ
*/


public class NextGreaterElement {

    public static void main(String []args){

        int arr[] = {2,5,9,3,1,12,6,8,7};
        int n = arr.length;
        int nge[] = new int[n]; //next greater element array
        Stack<Integer> st = new Stack<>();

        nge[n-1] = -1;
        st.push(arr[n-1]);

        for(int i=(n-2);i>=0;i--){

            while( st.size() > 0 && st.peek() < arr[i]){
                st.pop();
            }

            if(st.isEmpty())
                nge[i]=-1;
            else
                nge[i] = st.peek();
            

            st.push(arr[i]);
        }

        System.out.println(Arrays.toString(nge));

    }
    
}
