import java.util.HashSet;
import java.util.Set;

/*
Given a string Str which may contains lowercase and uppercase chracters. 
The task is to remove all duplicate characters from the string and find the resultant string. 
The order of remaining characters in the output should be same as in the original string.

Example 1:

Input:
Str = geeksforgeeks
Output: geksfor
Explanation: After removing duplicate
characters such as e, k, g, s, we have
string as "geksfor".

Example 2:

Input:
Str = HappyNewYear
Output: HapyNewYr
Explanation: After removing duplicate
characters such as p, e, a, we have
string as "HapyNewYr".

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)
*/

public class RemoveDuplicatesFromString {
    public static void main(String[] args) {

        String s1 = "GeeksForGeeks";
        String s2 = "HappyNewYear";

        System.out.println(removeDuplicates(s1));
        
        System.out.println(removeDuplicates(s2));
        
    }

    private static String removeDuplicates(String s) {

        String ans = "";
        
        Set<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(!set.contains(ch)){
                ans += ch;
                set.add(ch);
            }
        }

        return ans;
    }
}
