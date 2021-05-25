public class IntersectionOfSortedArray {

    public static void main(String []args){

        int arr1[] = {1,2,3,4,5};
        int arr2[] = {1,2,3,6,7};
        int n = arr1.length;
        int m = arr2.length;

        int i = 0; // pointer for first array
		int j = 0; // pointer for second array

		while( i != n && j != m){
			if(arr1[i] == arr2[j]){ //both are same 
				System.out.println(arr1[i]);
				i++;
				j++;
			}else if(arr1[i] < arr2[j]){  
				i++;
			}else{
				j++;
			}
		}

    }
    
}
