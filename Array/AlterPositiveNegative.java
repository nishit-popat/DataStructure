import java.util.ArrayList;
import java.util.Arrays;

/*
Given an unsorted array Arr of N positive and negative numbers. 
Your task is to create an array of alternate positive and negative numbers without changing 
the relative order of positive and negative numbers.
Note: Array should start with positive number.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)
 
Example 1:
Input: 
N = 9
Arr[] = {9, 4, -2, -1, 5, 0, -5, -3, 2}
Output:
9 -2 4 -1 5 -5 0 -3 2

Example 2:
Input: 
N = 10
Arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
Output:
5 -5 2 -2 4 -8 7 1 8 0 

*/

public class AlterPositiveNegative {
    public static void main(String[] args) {

        int arr1[] = {9, 4, -2, -1, 5, 0, -5, -3, 2};
        int arr2[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        int n1 = arr1.length;
        int n2 = arr2.length;

        alternateArray(arr1,n1);
        alternateArray(arr2, n2);
        
    }

    public static void alternateArray(int[] arr,int n){
        ArrayList<Integer> pos = new ArrayList<>(); //to store positive element
        ArrayList<Integer> neg = new ArrayList<>(); //to store negative element
        for(int i=0;i<n;i++){
            if(arr[i] < 0){
                neg.add(arr[i]);
            }
            else{
                pos.add(arr[i]);
            }
        }

        int i=0;
        int j=0;
        int c=0;
        //alternatively put positive and negative in array
        while(i< pos.size() && j< neg.size()){
            if(c%2==0){
                arr[c++]=pos.get(i);
                i++;
            }
            else{
                arr[c++]=neg.get(j);
                j++;
            }
        }

        //if any positive remains then put it at last
        while(i<pos.size()){
            arr[c]=pos.get(i);
            i++;
            c++;
        }
        
        //if any negative remains then put it at last
        while(i<neg.size()){
            arr[c]=pos.get(j);
            j++;
            c++;
        }
        System.out.println(Arrays.toString(arr));
    }
    
}
