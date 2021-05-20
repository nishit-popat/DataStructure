import java.util.*;

class CharStackArray{

    //global variables
    char[] stack;
    int top;
    int maxSize;

    //Constructor
    CharStackArray(int maxSize){
        this.maxSize = maxSize;
        this.stack = new char[maxSize];
        this.top = -1;
    }

    //push elements into stack
    public void push(char x){
        if(top == maxSize-1){
            System.out.println("Stack is overflow");
            return;
        }
        top = top + 1;
        stack[top] = x;
    }

    //remove element from stack
    public char pop(){
        if (top == -1){
            System.out.println("Stack is empty");
            return 0;
        }
        else{
            top = top-1;
            return stack[top+1];
        }
    }

    //first element of stack
    public char top(){
        return stack[top];
    }

    //If stack is empty
    public boolean isEmpty(){
        if(top == -1){
            return true;
        }
        return false;
    }

    //If stack is full
    public boolean isFull(){
        if(top == maxSize-1){
            return true;
        }
        return false;
    }

    //print the stack
    public void printStack(){
        if(isEmpty()){
            return;
        }
        else{
            for(int i=top; i>=0; i--){
                System.out.println(pop());
            }
        }
    }

}

public class ReverseString{

    private static String Reverse(String s, int length) {

        CharStackArray stack = new CharStackArray(20);
        String reversed = "";
        for(int i = 0; i < s.length(); i++){
            stack.push(s.charAt(i));
        }

        for(int i=0;i<s.length();i++){
            String poppedChar = Character.toString(stack.pop());
            reversed = reversed.concat(poppedChar);
        }
        return reversed;

    }


    public static void main(String []args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a String : ");
        String s = scan.nextLine();

        String reversedString = Reverse(s, s.length());

        System.out.println("Output String : " + reversedString);

        scan.close();
    }

   
}