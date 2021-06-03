import java.util.Stack;


public class InfixEvaluation {

    public static void main(String[] args) {
        String exp = "2+3*7/4+(3*4+(8-2))";
        Stack<Integer> operands = new Stack<>();  // Stack to store operands
        Stack<Character> operators = new Stack<>(); // Stack to store operators

        for(int i=0;i<exp.length();i++){
            char ch = exp.charAt(i); // current character

            if(ch=='('){
                operators.push(ch);
            }
            else if(Character.isDigit(ch)){
                operands.push(ch-'0');  // char to int
            }
            else if(ch==')'){
                // pop until matching opening bracket is not found and perform operation for every popped operator
                while(operators.peek() != '('){
                    char operator = operators.pop();
                    int v2 = operands.pop();
                    int v1 = operands.pop();

                    int opv = operation(v1, v2, operator);
                    operands.push(opv); // push value into operands stack after performing operation
                }
                operators.pop();
            }
            else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                // ch is wanting higher priority operators to work first
                while(operators.size() > 0 && operators.peek() != '(' && 
                precedence(ch) <= precedence(operators.peek())){

                    char operator = operators.pop();
                    int v2 = operands.pop();
                    int v1 = operands.pop();

                    int opv = operation(v1, v2, operator);
                    operands.push(opv);
                }
                // ch will push itself
                operators.push(ch);
            }

        }

        // any remaining operator from stack will pop out and perform operations 
        while(operators.size() != 0){
            char operator = operators.pop();
            int v2 = operands.pop();
            int v1 = operands.pop();

            int opv = operation(v1, v2, operator);
            operands.push(opv);
        }

        System.out.println(operands.pop());

    }
    
    // This function will return precedence of particular operator
    public static int precedence(char operator){
        if(operator=='+' || operator=='-'){
            return 1;
        }
        else if(operator=='*' || operator=='/'){
            return 2;
        }
        return 0;
    }

    // This function will perform operations of two popped items according to their operator
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
