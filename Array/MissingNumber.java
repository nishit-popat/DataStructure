public class MissingNumber {

    public static void main(String []args){

        int arr[] = {1,2,3,5};
        int n = 5;

        int element = findUsingSumDifference(arr, n);
        int element2 = findUsingXOR(arr, n);

        System.out.println(element + "       " + element2);
    }

    private static int findUsingXOR(int[] arr, int n) {
        int temp1=0;
        for(int i=1;i<=n;i++){
            temp1 = temp1 ^ i;
        }
        int temp2=0;
        for(int i=0;i<arr.length; i++){
            temp2 = temp2 ^ arr[i];
        }

        return temp1^temp2;
        
    }

    private static int findUsingSumDifference(int[] arr, int n) {
        int sum = (n*(n+1))/2;
        int arrSum = 0;
        for(int i=0;i<arr.length;i++){
            arrSum += arr[i];
        }
        return sum-arrSum;
    }
    
}
