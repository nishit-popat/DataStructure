public class ReverseString2 {
    public static void main(String[] args) {
        String s = "Nishit Popat";

        reverse(s.toCharArray());
        
    }

    private static void reverse(char[] s) {
        int n = s.length;

        //two pointer method
        int l = 0;
        int h = n - 1;

        while(l < h){
            char temp = s[l];
            s[l] = s[h];
            s[h] = temp;
            l++;
            h--;
        }
        System.out.println(s);
        
    }
    
}
