// Explaination Video Link : https://www.youtube.com/watch?v=1ZGJzvkcLsA
public class PrintSpiralMatrix {
    public static void main(String[] args) {
        int [][]arr = { {1, 2, 3, 4, 5},
                        {5, 6, 7, 8, 9},
                        {10, 11, 12, 13, 14},
                        {15, 16, 17, 18, 19},
                        {20, 21, 22, 23, 24},
                        {25, 26, 27, 28, 29}
                    };

        int totalRows = arr.length;
        int totalCols = arr[0].length;
 
        int top = 0;  // pointer to top of first row
        int down = totalRows - 1; // pointer to last row
        int left = 0; // pointer to first column column
        int right = totalCols - 1; // pointer to last column

        // it will determine direction 
        // 0 -> left to right
        // 1 -> top to bottom
        // 2 -> right to left
        // 3 -> bottom to top
        int dir = 0;  

        while(left <= right && top <= down){
            if(dir == 0){
                for(int i = left; i <= right; i++){
                    System.out.print(arr[top][i] + " ");
                }
                top++;
            }
            else if(dir == 1){
                for(int i = top; i<= down; i++){
                    System.out.print(arr[i][right] + " ");
                }
                right--;
            }
            else if(dir == 2){
                for(int i=right; i>=left; i--){
                    System.out.print(arr[down][i] + " ");
                }
                down--;
            }
            else{
                for(int i=down; i>= top; i--){
                    System.out.print(arr[i][left] + " ");
                }
                left++;
            }

            dir = (dir + 1)%4;
        }
    }
    
}
