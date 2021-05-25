import java.util.Arrays;

public class CyclyRotateByOne {

    public static void main(String []args){
        int arr[] = {1, 2, 3, 4, 5};
        int n = arr.length;
        System.out.println("Array : "+Arrays.toString(arr));
        int temp =arr[n-1];
    
        for(int i=(n-1);i>0;i--){
            arr[i] = arr[(i-1)%n]; 
        }
        arr[0] = temp;
        
        System.out.print("Array after rotation by one : "+Arrays.toString(arr));
    }
}
