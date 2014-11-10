package bitmanipulation;

public class MakeSubstring {

	public static void main(String[] args) {
			MakeSubstring m = new MakeSubstring();
			int pattern_1 = 256, pattern_2 = 11; 
			int result = m.makeSubString(pattern_1, pattern_2, 2, 5);
			
			m.printBinaryPattern("Pattern 1", pattern_1);
			m.printBinaryPattern("Pattern_2", pattern_2);
			m.printBinaryPattern("Result", result);

	}
	
	public void printBinaryPattern(String s, int a){
			System.out.println(s+"\t\t\t"+Integer.toBinaryString(a));
	}

	public int makeSubString(int n, int m, int i, int j){
			int left = ~0 - ((1<<j)-1), right = ((1<<i)-1);
			int mask = left | right;
			return (n & mask) | (m << i);
	}

}
