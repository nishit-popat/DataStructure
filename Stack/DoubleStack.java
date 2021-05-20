
/*
 Create a data structure twoStacks that represents two stacks. 
 Implementation of twoStacks should use only one array, 
 i.e., both stacks should use the same array for storing elements. 
 Following functions must be supported by twoStacks.
    push1(int x) –> pushes x to first stack 
    push2(int x) –> pushes x to second stack
    pop1() –> pops an element from first stack and return the popped element 
    pop2() –> pops an element from second stack and return the popped element
*/

public class DoubleStack {

    int size;
   public int stackarray[];
    int top1, top2;

    DoubleStack(int n){
        this.size = n;
        stackarray = new int[n];
        this.top1 = -1;
        this.top2 = size;
    }

    //push form front
    void push1(int x){
        if(top2 == top1+1){
            System.out.println("Stack Overflow");
            System.exit(1);
        }
        else{
            top1++;
            stackarray[top1]=x;
        }
    }

    //push from end
    void push2(int x){
        if(top2 == top1+1){
            System.out.println("Stack Overflow");
            System.exit(1);
        }
        else{
            top2--;
            stackarray[top2]=x;
        }
    }
    
    //pop from front
    int pop1(){
        if(top1 == -1){
            System.out.println("Stack is Empty");
            return -1;
        }
        else{
            int x = stackarray[top1];
            top1--;
            return x;
        }
     }

    //pop from end
    int pop2(){
        if(top2 == size){
            System.out.println("Stack is Empty");
            return -1;
        }
        else{
            int x = stackarray[top2];
            top2--;
            return x;
        }
    }

    //print from top
    void print1(){
        if(top1 == -1){
            System.out.println("Stack is Empty");
            System.exit(1);
        }
        else{
            for(int i=top1;i>=0;i--){
                System.out.print(stackarray[i] + "  ");
            }
            System.out.println();
        }
    }

    //print from end
    void print2(){
        if(top2 == size){
            System.out.println("Stack is Empty");
            System.exit(1);
        }
        else{
            for(int i=top2; i<size;i++){
                System.out.print(stackarray[i] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String []args){


        DoubleStack ds = new DoubleStack(5);
        ds.push1(2);
       // ds.print1();
        ds.push1(3);
       // ds.print1();
        ds.push2(4);
       // ds.print2();
        ds.pop1();
       // ds.print1();
        ds.pop2();
        //ds.print2();
    }
}

