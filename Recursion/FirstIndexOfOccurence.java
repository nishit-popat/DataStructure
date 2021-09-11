package Recursion;

public class FirstIndexOfOccurence {
    public static void main(String[] args) {
        int arr[] = {2, 3, 1, 3, 9, 10, 4, 6, 3};
        int data = 3;

        int ansIndex = findFirstOccurence(arr, 0, data);
        System.out.println(ansIndex);
    }

    private static int findFirstOccurence(int[] arr, int i, int data) {
        if(i == arr.length - 1)
            return -1;

        if(arr[i] == data){
            return i;
        }
        return findFirstOccurence(arr, i+1, data);
    }
    
}
