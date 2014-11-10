package stacksAndQueues;

public class StackWithMin_1 {
	Node top;
	
	public static void main(String[] args) {
			StackWithMin_1 s = new StackWithMin_1();
			s.push(10);
			s.push(23);
			s.push(36);
			s.push(13);
			s.push(5);
			
			System.out.println("Minimum Element : ");
			System.out.println(s.min());
			
			s.pop();
			
			System.out.println("Minimum Element : ");
			System.out.println(s.min());
			
	}

	public void push(int d){
		Node n = new Node(d, Math.min(d, min()));
		n.next = top; top = n;
	}
	
	public int min(){
		if(top==null) return Integer.MAX_VALUE;
		else return top.belowMin;
	}
		
	public Node pop(){
		if(top==null) return null;
		Node n=top; top = top.next;
		return n;
	}
	
	class Node{
		Node next;
		int data;
		int belowMin;
		public Node(int data, int belowMin) {
			super();
			this.data = data;
			this.belowMin = belowMin;
		}
		
	}
}