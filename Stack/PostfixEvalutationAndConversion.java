import java.util.Stack;

public class PostfixEvalutationAndConversion {

    public static void main(String[] args) {
        String exp = "246*8/+3-";
        Stack<Integer> value = new Stack<>(); // Stack for values
        Stack<String> pre = new Stack<>(); // Stack for prefix
        Stack<String> in = new Stack<>(); // Stack for infix
        //Stack<Character> ops = new Stack<>(); // Stack for operators

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            // if character is digit then only we have to add in stacks
            if(ch>='0' && ch<='9'){
                value.push(ch-'0');
                in.push(ch+"");
                pre.push(ch+"");
            }
            // if character is operator then in value stack we have to add value, 
            // in prefix stack we have to add prefix expression 
            // and in postfix stack we have to add postfix expression
            else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                int v2 = value.pop();
                int v1 = value.pop();

                int val =  operation(v1, v2, ch);
                value.push(val);

                String inv2 = in.pop();
                String inv1 = in.pop();
                String inval = "(" + inv1 + ch + inv2 + ")";
                in.push(inval);

                String prev1 = pre.pop();
                String prev2 = pre.pop();
                String preval = ch + prev1 + prev2;
                pre.push(preval);
            }
        }

        System.out.println(value.pop());
        System.out.println(in.pop());
        System.out.println(pre.pop());
    }
    // return the value respective of its operation
    public static int operation(int v1, int v2, char operator){
        if(operator=='+')
            return v1+v2;
        else if(operator=='-')
            return v1-v2;
        else if(operator=='*')
            return v1*v2;
        else    
            return v1/v2;
    }
    
}
