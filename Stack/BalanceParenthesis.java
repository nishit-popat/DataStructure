//check if string of parenthisis is balanced or not
// Input:
// {([])}

// Output: 
// true

// Input: 
// ([]

// Output: 
// false


import java.util.*;
public class BalanceParenthesis {

    public static void main(String []args){

        String a = "(A*{B+C})";
        String b = "{(})";
        String c = "()";
        System.out.println(checkBalancedParenthesis(a));
        System.out.println(checkBalancedParenthesis(b));
        System.out.println(checkBalancedParenthesis(c));
        
    }

    private static boolean checkBalancedParenthesis(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){

            char ch = s.charAt(i);

            if(ch =='{' || ch =='(' || ch =='['){
                stack.push(ch);
            }else if(ch ==')' || ch =='}' || ch ==']'){
                if((!stack.isEmpty() && stack.peek() == '(' && ch == ')') || (!stack.isEmpty() && stack.peek() == '{' && ch == '}') || (!stack.isEmpty() && stack.peek() == '[' && ch == ']')){
                    stack.pop();
                }else{
                    return false;
                }
            }
            
        }
        return stack.isEmpty() ? true : false;
    }
}