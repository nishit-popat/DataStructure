/*
How do you find the length of the longest substring without repeating characters?
*/

public class LongestSubString {
    public static void main(String[] args) {
        
        String str = "abcdefcdghudv";

        System.out.println(longsestSubString(str));
    }

    private static String longsestSubString(String str) {

        String css = ""; // current Sub String
        String lss = ""; // longest Sub String till
        
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);

            // if current sub string contains current character
            if(css.indexOf(ch) >= 0){

                // remove characters from beginning of the string until we find the current character and remove it also
                while( css.indexOf(ch) >= 0){
                    css = css.substring(1);
                }

                // then add current character into current string
                css += ch;
            }
            // if current sub string does not contain current character
            else{
                css += ch; // add current character into current sub string

                // lss will contain longest substring till current and at last it will contain longest sub string
                if(lss.length() < css.length()){
                    lss = css;
                }
            }
        }

        return lss;
    }
    
}
