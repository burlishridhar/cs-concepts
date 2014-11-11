package bitmanipulation;

public class Snoob {

	public static void main(String[] args) {
			Snoob s = new Snoob();
			int number = 244;
			
			System.out.print("Original Pattern:\t\t");
			System.out.println(Integer.toBinaryString(number));
			
			int higher = s.getNextHigher(number);
			System.out.print("Higher Pattern:\t\t");
			System.out.println(Integer.toBinaryString(higher));
			
			int lower = s.getNextLower(number);
			System.out.print("Lower Pattern:\t\t");
			System.out.println(Integer.toBinaryString(lower));
			
	}
	
	public void printBinary(String s, int n){
		System.out.println(s+"\t\t"+Integer.toBinaryString(n));
	}
	
	public int getNextHigher(int n){
			int smallest = n & -n;
			printBinary("Smallest", smallest);
			
			int ones = n ^ (n+smallest);
			printBinary("ones", ones);
			
			ones = (ones>>2)/smallest;
			printBinary("ones", ones);
			
			printBinary("(n+smallest) | ones", ((n+smallest) | ones));
			return (n+smallest) | ones;		
	}
	
	public int getNextLower(int n){
			return ~getNextHigher(~n);
	}

}
