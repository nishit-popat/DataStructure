public class RepairPothole {
    public static void main(String[] args) {
        
        String s1 = ".X..X.";  // ans : 2
        String s2 = "X.XXXXX.X"; // ans : 3
        String s3 = "XX.XXX.."; // ans : 2
        String s4 = "X..........X..."; // ans : 2


        System.out.println(solution(s1, s1.length()));
        System.out.println(solution(s2, s2.length()));
        System.out.println(solution(s3, s3.length()));
        System.out.println(solution(s4, s4.length()));
        
    }

    public static int solution(String s, int n){

        int i = 0;
        int count = 0;
        while(i < n){
            if(s.charAt(i) == '.'){
                i++;
            }
            else{
                count++;
                i = i+3;
            }
        }

        return count;
        
    }
    
}
