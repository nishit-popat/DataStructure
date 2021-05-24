import java.util.Arrays;

public class MoveNegativeElements {

    public static void main(String []args){

        int arr[] = {-1,-3,3,-4,21,91};
        int left = 0;

        for(int i=0;i<arr.length;i++){
            if(arr[i] < 0){
                int temp = arr[i];
                arr[i] = arr[left];
                arr[left] = temp;
                left++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    
}
