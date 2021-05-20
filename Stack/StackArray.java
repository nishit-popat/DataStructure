public class StackArray{

    //global variables
    int[] stack;
    int top;
    int maxSize;

    //Constructor
    StackArray(int maxSize){
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
        this.top = -1;
    }

    //push elements into stack
    public void push(int x){
        if(top == maxSize-1){
            System.out.println("Stack is overflow");
            return;
        }
        top = top + 1;
        stack[top] = x;
    }

    //remove element from stack
    public int pop(){
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
    public int top(){
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

    public static void main(String []args){

        StackArray demoStack = new StackArray(5);
        demoStack.push(3);
        demoStack.push(5);
        demoStack.push(7);
        demoStack.pop();
        demoStack.push(9);
        demoStack.top();
        demoStack.isEmpty();
        demoStack.isFull();
        demoStack.printStack();

    }
}