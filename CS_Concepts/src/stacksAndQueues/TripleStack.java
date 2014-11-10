package stacksAndQueues;

public class TripleStack {
	int [] arr = new int[300];
	int []tops = {0,0,0};
	
	public static void main(String[] args) {
		TripleStack t = new TripleStack();
		t.push(0, 1);
		t.push(0, 2);
		t.push(0, 3);
		
		t.push(1, 4);
		t.push(1, 5);
		t.push(1, 6);
		
		t.push(2, 7);
		t.push(2, 8);
		t.push(2, 9);
		
		t.printStacks();
		
		t.pop(0);
		t.pop(2);
		
		t.printStacks();
		
		
	}
	
	public void push(int stacknum, int d){
			arr[stacknum*100 + tops[stacknum] +1] = d;
			tops[stacknum]++;
	}

	public int pop(int stacknum){
			int val = arr[stacknum*100 + tops[stacknum]];
			tops[stacknum]--;
			return val;
	}

	public void printStacks(){
		for(int i=0; i<3; i++){
			System.out.println("Stack "+i);
			printStack(arr, i*100 +1, i*100 + tops[i]);
		}
			
	}
	
	private void printStack(int[] arr, int start, int stop){
		for(int i=start; i<=stop; i++){
			System.out.println("\tValue "+i+" : "+arr[i]);
		}
	}
}
