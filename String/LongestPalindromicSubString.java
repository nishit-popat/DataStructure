/*

Given a string S, find the longest palindromic substring in S. 
Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). 
Palindrome string: A string which reads the same backwards. 
More formally, S is palindrome if reverse(S) = S. 
Incase of conflict, return the substring which occurs first ( with the least starting index).


Example 1:

Input:
S = "aaaabbaa"
Output: aabbaa
Explanation: The longest Palindromic
substring is "aabbaa".

Example 2:

Input: 
S = "abc"
Output: a
Explanation: "a", "b" and "c" are the 
longest palindromes with same length.
The result is the one with the least
starting index.


youtube : https://www.youtube.com/watch?v=WpYHNHofwjc and https://www.youtube.com/watch?v=UflHuQj6MVA(TechDose)
*/
public class LongestPalindromicSubString {
    public static void main(String[] args) {
        String str = "aaaabbaa";
        String str2 = "abc";

        System.out.println(longestPalindromicSubString(str));
        System.out.println(longestPalindromicSubString(str2));

        System.out.println(longestPalindromicSubStringBruteForce(str));
        System.out.println(longestPalindromicSubStringBruteForce(str2));

    }

    private static String longestPalindromicSubString(String s) {

        boolean[][] dp = new boolean[s.length()][s.length()];
        //int len = 0;
        String ans = "";

        for (int g = 0; g < s.length(); g++) {

            for (int i = 0, j = g; j < s.length(); i++, j++) {

                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }

                if (dp[i][j] == true) {
                    //len = g + 1;
                    ans = s.substring(i, j+1);
                }
            }
        }
        return ans;
    }

    public static String longestPalindromicSubStringBruteForce(String s){
     
        String lps = "";
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(isPalindrome(s.substring(i,j+1))){
                    String t = s.substring(i,j+1);
                    if(t.length() > lps.length()){
                        lps = t;
                    }
                }
            }
        }
        return lps;
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
