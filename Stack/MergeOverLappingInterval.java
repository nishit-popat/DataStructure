import java.util.*;
/*
1. You are given a number n, representing the number of time-intervals.
2. In the next n lines, you are given a pair of space separated numbers.
3. The pair of numbers represent the start time and end time of a meeting 
    (first number is start time and second number is end time)
4. You are required to merge the meetings and print the merged meetings output in increasing order of start time.

E.g. Let us say there are 6 meetings
1 8
5 12
14 19
22 28
25 27
27 30

Then the output of merged meetings will belongs
1 12
14 19
22 30

Note -> The given input maynot be sorted by start-time.
*/

// Public class for pair of start time and end time
class Pair implements Comparable<Pair>{
    int start_time;
    int end_time;

    Pair(int start_time, int end_time){
        this.start_time = start_time;
        this.end_time = end_time;
    }
    //this > other return +ve
    //this = other return 0
    //this < other return -ve
    public int compareTo(Pair other){
        if(this.start_time != other.start_time)
            return this.start_time-other.start_time;  // start time of this then it will return +ve
        else
            return this.end_time - other.end_time; // if start time is same then it will check for end time
        
    }   
}
public class MergeOverLappingInterval {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int arr[][] = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = scan.nextInt();
            arr[i][1] = scan.nextInt();
        }
        scan.close();
        MergeOverLappingIntervals(arr, n);
    }

    private static void MergeOverLappingIntervals(int[][] arr, int n) {
        Pair[] pairs = new Pair[n];
        for(int i=0;i<n;i++){
            pairs[i] = new Pair(arr[i][0], arr[i][1]);  // convert array into pairs
        }

        Arrays.sort(pairs);  // this will sort according to start time of pairs
        Stack<Pair> st = new Stack<>();

        for(int i=0; i<pairs.length; i++){
            if(i==0){
                st.push(pairs[i]);
            }
            else{
                Pair top = st.peek(); 

                // if top element in stack has lesser end time then current element than it will just push
                if(pairs[i].start_time > top.end_time){
                    st.push(pairs[i]); 
                }
                else{
                    top.end_time = Math.max(top.end_time, pairs[i].end_time);
                }
            }
        }

        // to invert stack new stack is created
        Stack<Pair> rs = new Stack<>();
        while(st.size() > 0){
            rs.push(st.pop());
        }

        while(rs.size()>0){
            Pair p = rs.pop();
            System.out.println(p.start_time + " " + p.end_time); 
        }
    }
    
}
