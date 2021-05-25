import java.util.ArrayList;

public class UnionOfTwoSortedArrays {

    public static void main(String[] args){

        int a[] = {1, 2, 4, 5};
        int b[] = {1, 2, 3, 6, 7};

        printUnion(a,b);
        ArrayList<Integer> list = new ArrayList<>();
        list = findUnion(a, b, a.length, b.length); // This function is from gfg 
        System.out.print(list.toString());
    }

    private static void printUnion(int[] a, int[] b) {

        int i = 0; // pointer for first array
		int j = 0; // pointer for second array
        int n = a.length;
        int m = b.length;

		while( i != n && j != m){
			if(a[i] == b[j]){ //both are same 
				System.out.println(a[i]);
				i++;
				j++;
			}else if(a[i] < b[j]){  //printing smaller element
				System.out.println(a[i]);
				i++;
			}else{
				System.out.println(b[j]);
				j++;
			}
		}

		while(i < n){ //if elements are remaining in arr1
			System.out.println(a[i]);
			i++;
		}
		while(j < m){//if elements are remaining in arr2
			System.out.println(b[j]);
			j++;
		}
    }
    
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        int i = 0; // pointer for first array
		int j = 0; // pointer for second array
		ArrayList<Integer> list = new ArrayList<>();
		
		while( i != n && j != m){
			if(arr1[i] == arr2[j]){
			    if(list.size() > 0 && list.get(list.size()-1) != arr1[i]) 
				    list.add(arr1[i]);
				else if(list.size() == 0)
				    list.add(arr1[i]);
			    i++;
				j++;
			    
			}else if(arr1[i] < arr2[j]){  
			    if(list.size() > 0 && list.get(list.size()-1) != arr1[i])
			        list.add(arr1[i]);
			    else if(list.size() == 0)   
			        list.add(arr1[i]);
				i++;
			    
			}else{
			    if(list.size() > 0 && list.get(list.size()-1) != arr2[j])
				    list.add(arr2[j]);
				else if(list.size() == 0)
				    list.add(arr2[j]);
				j++;
			}
		}

		while(i < n){ //if elements are remaining in arr1
		    if(list.size() > 0 && list.get(list.size()-1) != arr1[i]) 
				list.add(arr1[i]);
			else if(list.size() == 0)
				list.add(arr1[i]);
		    
			
			i++;
		}
		while(j < m){//if elements are remaining in arr2
		     if(list.size() > 0 && list.get(list.size()-1) != arr2[j])
			     list.add(arr2[j]);
			 else if(list.size() == 0)   
			     list.add(arr2[j]);
			
			j++;
		}
		return list;
    }
}
