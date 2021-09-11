package Recursion;

public class MaxOfArray {
    public static void main(String[] args) {
        int []arr={10,23,36,21,19};
        int max = maxElement(arr, arr.length-1);
        System.out.println(max);
    }

    private static int maxElement(int[] arr, int length) {
        if(length == 0){
            return -1;
        }

        int t = maxElement(arr, length-1);
        if(arr[length] > t){
            return arr[length];
        }
        return t;
    }
    
}
