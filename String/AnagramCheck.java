/*
Given two strings a and b consisting of lowercase characters. 
The task is to check whether two given strings are an anagram of each other or not. 
An anagram of a string is another string that contains the same characters, 
only the order of characters can be different. 
For example, “act” and “tac” are an anagram of each other.

Example 1:

Input:
a = geeksforgeeks, b = forgeeksgeeks
Output: YES
Explanation: Both the string have same
characters with same frequency. So, 
both are anagrams.

Example 2:

Input:
a = allergy, b = allergic
Output: NO
Explanation:Characters in both the strings
are not same, so they are not anagrams.


Here we can have different ways to solve this problem I will create different functions for that.
*/

import java.util.*;

public class AnagramCheck {

    public static void main(String[] args) {

        String s1 = "abcdefghi";
        String s2 = "ighabcedf";

        // Method 1 : using map find occurences of all characters in both string
        // and then compare both hashmap 
        // Time Complexity : O(N), Space Complexity : O(N)
        System.out.println(isAnagram(s1, s2));


        // Method 2 : by sorting both the strings and then compare it
        // Time Complexity : O(NlogN), Space Complexity : O(1)
        System.out.println(isAnagram2(s1, s2));

    }

    public static boolean isAnagram(String a, String b) {

        if(a.length() != b.length()){
            return false;
        }

        Map<Character, Integer> mp1 = new HashMap<>();
        Map<Character, Integer> mp2 = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {

            if (!mp1.containsKey(a.charAt(i))) {
                mp1.put(a.charAt(i), 1);
            } else {
                int t = (int) mp1.get(a.charAt(i));
                mp1.put(a.charAt(i), t + 1);
            }
        }

        for (int i = 0; i < b.length(); i++) {

            if (!mp2.containsKey(b.charAt(i))) {
                mp2.put(b.charAt(i), 1);
            } else {
                int t = (int) mp2.get(b.charAt(i));
                mp2.put(b.charAt(i), t + 1);
            }
        }

        // System.out.println(mp1.toString());
        // System.out.println(mp2.toString());

        return mp1.equals(mp2);
    }

    private static boolean isAnagram2(String s1, String s2) {

        char c1[] = s1.toCharArray();
        char c2[] = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);  // here == or .equals method will not work
    }
}
