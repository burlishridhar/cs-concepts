package recursion;

public class Fibonacci {

	public static void main(String[] args) {
			Fibonacci f = new Fibonacci();
			System.out.println(f.fibonacci(10));
	}
	
	public int fibonacci(int n){
			if(n==0) return 0;
			else if(n==1) return 1;
			return fibonacci(n-1) + fibonacci(n-2);
	}

}
