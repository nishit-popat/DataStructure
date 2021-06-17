import java.util.*;

/*
Tom is a string freak. He has got sequences of  n words to manipulate.
If in a sequence, two same words come together then he’ll destroy each other. 
He wants to know the number of words left in the sequence after this pairwise destruction.
 

Example 1:

Input:
5
v[] = {"ab", "aa", "aa", "bcd", "ab"}
Output:
3
Explanation:
ab aa aa bcd ab
After the first iteration, we'll have: ab bcd ab
We can't further destroy more strings and
hence we stop and the result is 3. 
 

Example 2:

Input:
4
v[] = {"tom", "jerry", "jerry", "tom"}
Output:
0
Explanation:
tom jerry jerry tom
After the first iteration, we'll have: tom tom
After the second iteration: 'empty-array' 
Hence, the result is 0. 
*/

public class StringManipulation {
    public static void main(String[] args) {
        String[] v = {"ab", "aa", "aa", "bcd", "ab"}; 
        Vector<String> vector = new Vector<String>(Arrays.asList(v));    

        System.out.println(removeConsecutiveSame(vector));
    }

    static int removeConsecutiveSame(Vector <String > v) 
    {
        Stack<String> st = new Stack<>();
        st.push(v.get(0));
        for(int i=1;i<v.size();i++){
            
            if(!st.isEmpty()){
                String s = st.peek();
                if(s.equals(v.get(i)))
                    st.pop();
                else st.push(v.get(i));
            }
            else{
                st.push(v.get(i));
            }
        }
        
        return st.size();
    }
}
