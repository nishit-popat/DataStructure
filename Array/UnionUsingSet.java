import java.util.HashSet;
import java.util.Set;

public class UnionUsingSet {

    public static void main(String[] args){
    
        int a[] = {1, 2, 3, 4, 5};
        int b[] = {1, 2, 3, 6};

        printUnion(a,b);
    
    }

    public static void printUnion(int[] a, int[] b) {
        Set<Integer> hash_Set = new HashSet<Integer>();
        for(int i=0;i<a.length;i++){
            hash_Set.add(a[i]);
        }
        for(int i=0;i<b.length;i++){
            hash_Set.add(b[i]);
        }
        System.out.println(hash_Set.toString());

    }   
}
