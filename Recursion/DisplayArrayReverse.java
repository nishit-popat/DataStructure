package Recursion;
public class DisplayArrayReverse{
    public static void main(String[] args) {
        int []arr={1,2,3,4,5};
        displayArrayReverse(arr,0);
    }

    private static void displayArrayReverse(int[] arr, int idx) {

        if(idx == arr.length)
            return;

        displayArrayReverse(arr, idx+1);
        System.out.println(arr[idx]);
    }
}