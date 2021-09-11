package Recursion;

public class DisplayArray {

    public static void main(String[] args) {
        int []arr={1,2,3,4,5};
        displayArray(arr, arr.length-1);
    }

    static void displayArray(int []arr, int idx){

        if(idx==-1)
            return;

        displayArray(arr, idx-1);
        System.out.print(arr[idx]+ " ");
    }
    
}
