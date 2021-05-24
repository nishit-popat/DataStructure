import java.util.Arrays;
public class ReverseArray{
    public static void main(String[] args){
        int arr[]={1,2,3,4,5,6};
        int n = arr.length;
        System.out.println(Arrays.toString(arr));
        int i=0, j=n-1;
        while(i<=j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        System.out.println(Arrays.toString(arr));
    }
}