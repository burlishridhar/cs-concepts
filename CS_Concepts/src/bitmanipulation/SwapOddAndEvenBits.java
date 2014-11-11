package bitmanipulation;

public class SwapOddAndEvenBits {

	public static void main(String[] args) {
		SwapOddAndEvenBits s = new SwapOddAndEvenBits();
		int num = 8;
		
		System.out.print("Old Pattern: ");
		System.out.println(Integer.toBinaryString(num));
		
		System.out.print("New Pattern: ");
		System.out.println(Integer.toBinaryString(s.bitSwap(num)));
		

	}
	
	public int bitSwap(int n){
		return (n & 0xAAAAAAAA)>>1 | (n & 0x55555555)<<1;
	}

}
