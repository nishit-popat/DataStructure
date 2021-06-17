import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BST {

    static class Node {
        int data;
        Node left, right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static Node createNewNode(int data) {
        Node temp = new Node(data, null, null);
        return temp;
    }

    static Node insert(Node root, int data) {
        if (root == null) {
            root = createNewNode(data);
        } else if (data <= root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    static Boolean search(Node root, int data) {
        if (root == null) {
            return false;
        }
        if (root.data == data)
            return true;
        else if (data > root.data) {
            return search(root.right, data);
        } else {
            return search(root.left, data);
        }
    }

    // find minimum element in bst
    int findMind(Node root) {
        if (root == null) {
            return -1;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    // find maximum element in bst
    int findMax(Node root) {
        if (root == null) {
            return -1;
        }
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    // find Min recursively
    int findMinRec(Node root) {
        if (root == null) {
            return -1;
        } else if (root.left == null) {
            return root.data;
        }

        // search in left subtree
        return findMinRec(root.left);
    }

    // find Max recursively
    int findMaxRec(Node root) {
        if (root == null) {
            return -1;
        } else if (root.right == null) {
            return root.data;
        }

        // search in right subtree
        return findMinRec(root.right);
    }

    // find height of binary tree O(N)
    int findHeight(Node root) {
        if (root == null) {
            return -1; // here we have to compulsorily return -1 because height of empty tree is -1
        }

        int leftHeight = findHeight(root.left); // This will give height of left subtree
        int rightHeight = findHeight(root.right); // This will give height of right subtree
        int height = Math.max(leftHeight, rightHeight) + 1;
        return height;

    }

    // level order traversal
    static void levelOrder(Node root){
        if(root == null){
            return;
        }
        else{
            Queue<Node> qu = new LinkedList<>();
            qu.add(root);

            // queue is not empty  Time Complexity : O(N), Space Complexity : O(N), Breadth First Traversal
            while(!qu.isEmpty()){
                Node current = qu.poll();
                System.out.print(current.data + " ");
                
                // if left child is not null then push it into queue
                if(current.left != null){
                    qu.add(current.left);
                }

                // if right child is not null then push it into queue 
                if(current.right != null){
                    qu.add(current.right);
                }
            }
                
            
        }
    }


    // Preorder traversal space complexity : O(h), Time Complexity : O(N)
    static void preorder(Node root){
        if(root == null) return; 
        System.out.print(root.data + "  ");
        preorder(root.left);
        preorder(root.right);
    }

    // Inorder traversal
    static void inorder(Node root){
        if(root == null) return; 
        inorder(root.left);
        System.out.print(root.data + "  ");
        inorder(root.right);
    }

     // Postorder traversal
    static void postorder(Node root){
        if(root == null) return; 
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + "  ");
    }

    

    static Node root;

    public static void main(String[] args) {
        root = null; // will point to root of tree

        root = insert(root, 15);
        root = insert(root, 10); 
        root = insert(root, 20);
        root = insert(root, 5);
        root = insert(root, 8);
        root = insert(root, 22);
        root = insert(root, 30);

        //System.out.println(search(root, 19));

        //System.out.println(search(root, 20));

        //levelOrder(root);


        System.out.println("Preorder : ");
        preorder(root);

        System.out.println("Inorder : ");
        inorder(root);

        System.out.println("Postorder : ");
        postorder(root);
        

    }

}
