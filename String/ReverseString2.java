public class ReverseString2 {
    public static void main(String[] args) {
        String s = "Nishit Popat";

        
        String ans = reverse(s.toCharArray());
        
        System.out.println(ans);
    }

    private static String reverse(char[] s) {
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
        //System.out.println(s);
        return new String(s);   
        
    }
    
}
