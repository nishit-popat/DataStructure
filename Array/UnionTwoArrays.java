import java.util.ArrayList;

public class UnionTwoArrays {

    public static void main(String []args){
        int a[] = {1, 2, 3, 4, 5};
        int b[] = {1, 2, 3, 6};

        printUnion(a,b);
        //System.out.print(Arrays.toString(arr));
    }

    public static void printUnion(int[] a, int[] b) {

        int size = a.length + b.length;
        ArrayList<Integer> arr = new ArrayList<Integer>(size);
        arr.add(a[0]);
        int j = 0;

        for(int i=1; i<a.length; i++){
            int flag = 0;
            int k = j;
            while(k>=0){
                if(arr.get(k)==a[i]){
                    flag = 1;
                    break;
                }
                k--;
            }
            if(flag == 0){
                j++;
                arr.add(a[i]);
            }
        }
        for(int i=0; i<b.length; i++){
            int flag = 0;
            int k = j;
            while(k>=0){
                if(arr.get(k)==b[i]){
                    flag = 1;
                    break;
                }
                k--;
            }
            if(flag == 0){
                j++;
                arr.add(b[i]);
            }
        }
        System.out.println("Hello");
        for(int i=0;i<arr.size();i++){
            System.out.print(arr.get(i) + "  ");
        }
    }
    
}
