package Basic;
import java.util.Arrays;

public class CountPossibleTriangles {
    public static void main(String[] args) {
        int arr[] = {2, 4, 6, 8, 9};
        
        System.out.println("Number of triangles possible : " + countTriangles(arr));
    }

    private static int countTriangles(int[] arr) {

        Arrays.sort(arr);

        int count = 0;
        for(int i=arr.length-1; i>=2; i--){

            int l = 0;
            int r = i-1;
            while(l < r){
                if(arr[l] + arr[r] > arr[i]){
                    count += r-l;
                    r--;
                }
                else{
                    l++;
                }
            }
        }
        return count;
    }
}
