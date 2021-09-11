package Recursion;

public class LastIndexOfOccurence {
    public static void main(String[] args) {
        int arr[] = {2, 3, 1, 3, 9, 10, 4, 6, 3, 7, 9};
        int data = 3;

        int ansIndex = findLastOccurence(arr, 0, data);
        System.out.println(ansIndex);

    }

    private static int findLastOccurence(int[] arr, int idx, int data) {

        if(idx == arr.length-1){
            return -1;
        }

        
        int liisa = findLastOccurence(arr, idx+1, data); // last index in smaller array
        if(arr[idx] == data){
            if(liisa == -1){
                return idx;
            }
            else{
                return liisa;
            }
        }
        else{
            return liisa;
        }
    }
    
}
