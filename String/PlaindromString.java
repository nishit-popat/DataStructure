public class PlaindromString {
    public static void main(String[] args) {
        String str = "naman";
        String str2 = "abababadaawaascawsaawwwa";
        String str3 = "aaabbbaaa";

        System.out.println(isPalindrome(str));
        System.out.println(isPalindrome(str2));
        System.out.println(isPalindrome(str3));
    }

    private static boolean isPalindrome(String str) {

        int p1=0, p2=str.length()-1;
        while(p1 <= p2){
            if(str.charAt(p1)!= str.charAt(p2)){
                return false;
            }
            else{
                p1++;
                p2--;
            }
        }
        return true;
    }
    
}
