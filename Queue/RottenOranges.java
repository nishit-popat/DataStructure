import java.util.LinkedList;
import java.util.Queue;

/*
Given a grid of dimension nxm where each cell in the grid can have values 
0, 1 or 2 which has the following meaning:
0 : Empty cell
1 : Cells have fresh oranges
2 : Cells have rotten oranges

We have to determine what is the minimum time required to rot all oranges. 
A rotten orange at index [i,j] can rot other fresh orange
 at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time. 
 

Example 1:

Input: grid = {{0,1,2},{0,1,2},{2,1,1}}
Output: 1
Explanation: The grid is-
0 1 2
0 1 2
2 1 1
Oranges at positions (0,2), (1,2), (2,0)
will rot oranges at (0,1), (1,1), (2,2) and 
(2,1) in unit time.

Example 2:

Input: grid = {{2,2,0,1}}
Output: -1
Explanation: The grid is-
2 2 0 1
Oranges at (0,0) and (0,1) can't rot orange at
(0,3).
 

Your Task:
You don't need to read or print anything, 
Your task is to complete the function orangesRotting() which takes grid as input parameter 
and returns the minimum time to rot all the fresh oranges. 
If not possible returns -1.
 

Expected Time Compelxity: O(n*m)
Expected Auxiliary Space: O(1)

*/

public class RottenOranges {

    public static void main(String[] args) {

        // int grid[][] = { { 2, 1, 0, 2, 1 }, { 1, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 } };
        int grid[][] = { { 0, 1, 2, }, { 0, 1, 2 }, { 2, 1, 1 } };
        int ans = orangesRotting(grid);
        System.out.println(ans);

    }

    private static int orangesRotting(int[][] grid) {

        int cols = grid[0].length;  // number of columns
        int rows = grid.length; // number of rows
        int ans = 0;

        Queue<Node> q = new LinkedList<>(); // create queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    // if any element is rotten then we will add them in queue
                    Node tempNode = new Node();
                    tempNode.timeStamp = 0; // at first timestamp will be 0
                    tempNode.m = i; // here we will store ith index
                    tempNode.n = j; // here we will store jth index
                    q.add(tempNode);
                }
            }
        }

        // this loop will run until queue is empty
        while (!q.isEmpty()) {
            Node t = q.poll(); // remove first element from queue
            int m = t.m; // m will store row index of current element
            int n = t.n; // n will store col index of current element

            // checks for up element of current element if it is 1 then convert it into 2 and add last at queue
            if (m > 0 && grid[m - 1][n] == 1) {
                grid[m - 1][n] = 2;
                int curTimeStamp = t.timeStamp;
                Node newNode = new Node();
                newNode.timeStamp = curTimeStamp + 1;
                newNode.m = m - 1;
                newNode.n = n;
                q.add(newNode);
                ans = newNode.timeStamp > ans ? newNode.timeStamp : ans;
            }
            // checks for left element of current element if it is 1 then convert it into 2 and add last at queue
            if (n > 0 && grid[m][n - 1] == 1) {
                grid[m][n - 1] = 2;
                int curTimeStamp = t.timeStamp;
                Node newNode = new Node();
                newNode.timeStamp = curTimeStamp + 1;
                newNode.m = m;
                newNode.n = n - 1;
                q.add(newNode);
                ans = newNode.timeStamp > ans ? newNode.timeStamp : ans;
            }
            // checks for down element of current element if it is 1 then convert it into 2 and add last at queue
            if (m < (rows - 1) && grid[m + 1][n] == 1) {
                grid[m + 1][n] = 2;
                int curTimeStamp = t.timeStamp;
                Node newNode = new Node();
                newNode.timeStamp = curTimeStamp + 1;
                newNode.m = m + 1;
                newNode.n = n;
                q.add(newNode);
                ans = newNode.timeStamp > ans ? newNode.timeStamp : ans;
            }
            // checks for right element of current element if it is 1 then convert it into 2 and add last at queue
            if (n < (cols - 1) && grid[m][n + 1] == 1) {
                grid[m][n + 1] = 2;
                int curTimeStamp = t.timeStamp;
                Node newNode = new Node();
                newNode.timeStamp = curTimeStamp + 1;
                newNode.m = m;
                newNode.n = n + 1;
                q.add(newNode);
                ans = newNode.timeStamp > ans ? newNode.timeStamp : ans;
            }
        }

        // for (int i = 0; i < rows; i++) {
        //     for (int j = 0; j < cols; j++) {
        //         System.out.print(grid[i][j] + " ");
        //     }
        //     System.out.println();
        // }


        // after all this operations still any element left in queue with 1 then we can say that 
        // all elements cannot be rotten so return -1
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return ans;

    }

    // Queue will be of this Node
    static class Node {
        int timeStamp;
        int m, n;
    }
}