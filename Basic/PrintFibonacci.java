package Basic;
class PrintFibonacci {

	static void Fibonacci(int N)
	{
		int num1 = 0, num2 = 1;

		int counter = 0;

		while (counter < N) {

			System.out.print(num1 + " ");

			// Swap
			int num3 = num2 + num1;
			num1 = num2;
			num2 = num3;
			counter = counter + 1;
		}
	}

    // Using dp
    static int fib(int n)
    {
        int f[] = new int[n + 2];
  
        int i;
  
        f[0] = 0;
        f[1] = 1;
  
        for (i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
    
	public static void main(String args[])
	{
		int N = 10;
        Fibonacci(N);
	}
}
