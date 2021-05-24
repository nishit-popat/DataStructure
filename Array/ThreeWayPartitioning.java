import java.util.Arrays;

/* Given an	array which	consists of	only 0,	1 and 2. Sort the array	without	
using any sorting	algorithm.	
Here, 9	is	the	size of	array input	by the user	followed by	the	elements input
    Sample Input : 9
    0 1 2 1 1 0 0 2 2
    Sample Output : 0 0 0 1 1 1 2 2 2
*/

public class ThreeWayPartitioning {

    public static void main(String []args){

        int arr[] = {0, 1, 2, 1, 1, 0, 0, 2, 2};
        int n = arr.length;
    
        int current = 0;
        int start = 0;
        int end = (n-1);

        while(current <= end){
            if(arr[current] == 1){
                current++;
            }
            else if(arr[current] == 0){
                int temp = arr[current];
                arr[current] = arr[start];
                arr[start] = temp;
                start++;
                current++;
            }
            else{
                int temp = arr[current];
                arr[current] = arr[end];
                arr[end] = temp;
                end--;
                current++;
            }
        }

        System.out.println(Arrays.toString(arr));
    
    }
}
