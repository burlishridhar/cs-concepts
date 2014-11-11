package bitmanipulation;

public class BitBasics {

	public static void main(String[] args) {
			int A = 23;
			
			System.out.print("Original Pattern\t\t");
			System.out.println(Integer.toBinaryString(A));
			
			System.out.print("Clear the second bit\t\t");
			A &= ~(1<<2);
			System.out.println(Integer.toBinaryString(A));
			
			System.out.print("Set the third bit\t\t");
			A |= 1<<3;
			System.out.println(Integer.toBinaryString(A));
			
			System.out.println();
			
			System.out.print("Get a set of 11 ones\t\t");
			A = (1<<11) - 1;
			System.out.println(Integer.toBinaryString(A));
			
			System.out.print("Get the rightmost set bit\t\t");
			A = 88; A &= -A;
			System.out.println(Integer.toBinaryString(A));
			
			System.out.print("Check if A is a power of two\t\t");
			A = 12; 
			System.out.println((A & (A-1))==0);
			
	}

}
