import java.util.Stack;

/*
Given a string of balanced expression, find if it contains a redundant parenthesis or not.
A set of parenthesis are redundant if same sub-expression is surrounded by unnecessary or multiple brackets. Print ‘Yes’ if redundant else ‘No’.
Note: Expression may contain ‘+‘, ‘*‘, ‘–‘ and ‘/‘ operators. 
Given expression is valid and there are no white spaces present.

Example:  
Input: 
((a+b))   ----> Yes
(a+(b)/c) ----> Yes
(a+b*(c-d)) --> No

Explanation:
1. ((a+b)) can reduced to (a+b), this Redundant
2. (a+(b)/c) can reduced to (a+b/c) because b is
surrounded by () which is redundant.
3. (a+b*(c-d)) doesn't have any redundant or multiple
brackets.
*/

public class RedundantBracket {

    public static void main(String[] args) {
        String str = "((a+b))";
        System.out.println(checkRedundancy(str));
 
        str = "(a+(b)/c)";
        System.out.println(checkRedundancy(str));
 
        str = "(a+b*(c-d))";
        System.out.println(checkRedundancy(str));
    }
    private static boolean checkRedundancy(String s){
        
        Stack<Character> st = new Stack<>();
        char[] str = s.toCharArray();
        // Iterate through the given expression
        for (char ch : str) {
 
            // if current character is close parenthesis ')'
            if (ch == ')') {
                char top = st.peek();
                st.pop();
 
                // If immediate pop have open parenthesis '('
                // duplicate brackets found
                boolean flag = true;
 
                while (top != '(') {
 
                    // Check for operators in expression
                    if (top == '+' || top == '-'
                            || top == '*' || top == '/') {
                        flag = false;
                    }
 
                    // Fetch top element of stack
                    top = st.peek();
                    st.pop();
                }
 
                // If operators not found
                if (flag == true) {
                    return true;
                }
            } else {
                st.push(ch); // push open parenthesis '(',
            }                // operators and operands to stack
        }
        return false;
    }
    
}
