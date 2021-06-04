import java.util.Stack;

public class InfixConversion {

    public static void main(String[] args) {
        String exp = "a+b*c+(c-d*f-(t+v)+m)";
        Stack<String> post = new Stack<>(); // Stack for postfix
        Stack<String> pre = new Stack<>(); // Stack for prefix
        Stack<Character> ops = new Stack<>(); // Stack for operators

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '(') {
                ops.push(ch);

            }
            // if current character is digit or alphabet
            else if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                post.push(ch + "");
                pre.push(ch + "");
            } else if (ch == ')') {
                // when matching opening bracket is not found this loop will continue
                while (ops.peek() != '(') {
                    char op = ops.pop();
                    String postv2 = post.pop();
                    String postv1 = post.pop();
                    String postv = postv1 + postv2 + op; // postfix string
                    post.push(postv);

                    String prev2 = pre.pop();
                    String prev1 = pre.pop();
                    String prev = op + prev1 + prev2; // prefix string
                    pre.push(prev);

                }
                ops.pop();
            }
            // if current character is operator 
            else if ((ch == '+') || (ch == '-') || (ch == '*') || (ch == '/') || (ch == '^')) {
                // if stack becomes empty or matching opening bracket is found or 
                // element with lower priority found then and then this loop will stop 
                // otherwise it keep computing values
                while (ops.size() > 0 && ops.peek() != '(' && precedence(ch) <= precedence(ops.peek())) {
                    char op = ops.pop();
                    String postv2 = post.pop();
                    String postv1 = post.pop();
                    String postv = postv1 + postv2 + op; // postfix string
                    post.push(postv);

                    String prev2 = pre.pop();
                    String prev1 = pre.pop();
                    String prev = op + prev1 + prev2; // prefix string
                    pre.push(prev);

                }

                ops.push(ch); // push current operator into stack

            }
        }

        // if operator stack is not empty
        while (ops.size() > 0) {
            char op = ops.pop();
            String postv2 = post.pop();
            String postv1 = post.pop();
            String postv = postv1 + postv2 + op;
            post.push(postv);

            String prev2 = pre.pop();
            String prev1 = pre.pop();
            String prev = op + prev1 + prev2;
            pre.push(prev);

        }

        System.out.println(post.pop()); // Printing postfix string
        System.out.println(pre.pop()); // Printing prefix string
    }

    // This function will return precedence of particular operator
    public static int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        } else if (operator == '^') {
            return 3;
        }
        return 0;
    }

}
