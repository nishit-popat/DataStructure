/* 
    In a party of N people, only one person is known to everyone. 
    Such a person may be present in the party,
    if yes, (s)he doesn’t know anyone in the party. 
    We can only ask questions like “does A know B? “. 
    Find the stranger (celebrity) in the minimum number of questions.
    We can describe the problem input as an array of numbers/characters representing persons in the party. 
    We also have a hypothetical function HaveAcquaintance(A, B) which returns true if A knows B, false otherwise. 
    How can we solve the problem. 

Examples:  

Input:
MATRIX = { {0, 0, 1, 0},
           {0, 0, 1, 0},
           {0, 0, 0, 0},
           {0, 0, 1, 0} }
Output:id = 2
Explanation: The person with ID 2 does not 
know anyone but everyone knows him

Input:
MATRIX = { {0, 0, 1, 0},
           {0, 0, 1, 0},
           {0, 1, 0, 0},
           {0, 0, 1, 0} }
Output: No celebrity
Explanation: There is no celebrity.

Explanation Of Solution : https://www.youtube.com/watch?v=CiiXBvrX-5A
*/

import java.util.*;
public class CelebrityProblem {

    public static void main(String []args){

        int arr[][] = { {0,0,0,1,0},
                        {0,0,0,1,0},
                        {0,0,0,1,0},
                        {0,0,0,0,0},
                        {0,0,0,1,0} };

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr){

        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            st.push(i);
        }

        while(st.size() >= 2){

            int i = st.pop();
            int j = st.pop();

            if(arr[i][j] == 1){
                // if i knows j -> i is not celebrity
                st.push(j);
            }
            else{
                // if i does not know j -> j is not celebrity
                st.push(i);
            }

        }

        // now last element in stack is potential celebrity he may be or may be not a celebrity
        int pot = st.pop();

        for(int i=0;i<arr.length;i++){
            if(i == pot){
                continue;
            }
            else{
                if(arr[i][pot] == 0 || arr[pot][i] == 1){
                    System.out.println("None");
                    return;
                }
            }
        }
        System.out.println(pot);
    }
    
}
