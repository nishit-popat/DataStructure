/*
This problem is basically that 
we are given euler path in the array form and we have to convert it into tree and 
display the tree as well.

https://www.youtube.com/watch?v=XV1ADVV6FbQ&list=PL-Jc9J83PIiHYxUk8dSu2_G7MR1PaGXN4&index=2
*/

import java.util.Stack;

public class ConstructorBinaryTree {
    private static class Node{
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    // There will be 3 states where 1 means push left side,
    // 2 means put right side
    // 3 means pop out this pair from stack
    private static class Pair{
        Node node;
        int state;

        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }
    
    public static void display(Node node){

        if(node == null) return;
        // node self work
        String str = "";

        str += node.left == null ? "." : node.left.data + "";
        str += "<-" + node.data + "->";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }
    public static void main(String[] args) {
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};

        Stack<Pair> st = new Stack<>();
        Node root = new Node(arr[0], null, null);
        Pair rp = new Pair(root, 1);  // root pair

        st.push(rp); // push root pair onto the stack

        int idx = 0;
        while(!st.isEmpty()){
            Pair top = st.peek(); // get top pair from stack

            // if state of top pair is 1 that means we have to push it onto left side of that Node
            if(top.state == 1){
                idx++; // first of index of array will increase

                // if array element is not null then we create the node and put it left of current top element of stack
                if(arr[idx] != null){
                    Node leftNode = new Node(arr[idx], null, null);
                    top.node.left = leftNode;

                    // push this node's pair onto the stack as well
                    Pair leftPair = new Pair(leftNode, 1);
                    st.push(leftPair);
                }
                top.state++; // increase the state so it will become 1 for current node that will indicate that now next time we have to add on right side of current node
            }

            // if current state is 2 then put node into right side
            else if(top.state == 2){
                idx++;
                if(arr[idx] != null){
                    Node righNode = new Node(arr[idx], null, null);
                    top.node.right = righNode;

                    Pair righPair = new Pair(righNode, 1);
                    st.push(righPair);
                }
                top.state++;
            }
            else{
                // if state is 3 then pop it out from stack
                st.pop();
            }
        }

        display(root);
        
    }
    
}
