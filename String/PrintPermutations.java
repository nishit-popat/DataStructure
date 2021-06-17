public class PrintPermutations {
    public static void main(String[] args) {
        String s = "abc";
        String ans = "";
        printPerm(s, ans);
    }

    // This function will use recursion and print all permutations of a string 
    // Here string s is input string and string ans is output string
    // character will be added to ans string one by one
    private static void printPerm(String s, String ans) {

        // at final recursion all the characters will be transfered to ans string and string s will become null
        if(s.length() == 0){
            System.out.println(ans);
        }

        // for first case assume s = abc 
        // so this loop will run 3 times for a,b and c
        for(int i=0;i<s.length();i++){

            // this will pick 1 character
            char ch = s.charAt(i);

            // this will bring left part 
            String leftPart = s.substring(0, i);

            // this will bring right part
            String rightPart = s.substring(i+1);
            
            // this will add left part and right part and only remains is current character
            String rest = leftPart + rightPart;

            // this will call add one character and rest string will have all other characters
            printPerm(rest, ans+ch); 
        }
    }
    
}
