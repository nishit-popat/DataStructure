/*
Given an array with all distinct elements, find the largest three elements. 
Expected time complexity is O(n) and extra space is O(1). 

Examples :
Input: arr[] = {10, 4, 3, 50, 23, 90}
Output: 90, 50, 23
*/

import java.util.Scanner;

public class FindThreeLargestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size of an array : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter elements of an array " );
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int x = arr[i];
            if(x > first){
                third = second;
                second = first;
                first = x;
            }
            else if(x > second){
                third = second;
                second = x;
            }
            else if(x > third){
                third = x;
            }
        }

        System.out.println("First Largest Number : " + first);
        System.out.println("Second Largest Number : " + second);
        System.out.println("Third Largest Number : " + third);
    }
    
}
