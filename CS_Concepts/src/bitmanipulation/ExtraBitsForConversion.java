package bitmanipulation;

public class ExtraBitsForConversion {

	public static void main(String[] args) {
		int num1 = 88, num2 = 14;
		
		System.out.print("Number 1: ");
		System.out.println(Integer.toBinaryString(num1));
		
		System.out.print("Number 2: ");
		System.out.println(Integer.toBinaryString(num2));
		
		ExtraBitsForConversion e = new ExtraBitsForConversion();
		System.out.print("Additional Bits for conversion: ");
		System.out.println(e.bitsRequired(num1, num2));
	}
	
	public int bitsRequired(int A, int B){
			int count = 0;
			for(int c=A^B;c!=0;c=c>>1)
					count += c & 1;
			return count - 1;
	}

}
