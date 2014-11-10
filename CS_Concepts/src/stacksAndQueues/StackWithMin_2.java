package stacksAndQueues;

public class StackWithMin_2 extends Stack_2{

	Stack_2 minStack;
	public StackWithMin_2(){
		minStack = new Stack_2();
	}

	public void push(int d){
		if(d<min()) minStack.push(d);
		super.push(d);
	}

	public Node pop(){
			if(super.peek()==min()) minStack.pop();
			return super.pop();
	}

	public int min(){
		if(minStack.top==null) return Integer.MAX_VALUE;
		else return minStack.peek();
	}

	public static void main(String[] args) {
		StackWithMin_2 s = new StackWithMin_2();
		s.push(118);
		s.push(23);
		s.push(36);
		s.push(13);
		s.push(5);
		
		System.out.println("Minimum Element : ");
		System.out.println(s.min());
		
		s.pop();s.pop();
		
		System.out.println("Minimum Element : ");
		System.out.println(s.min());
	}

}

class Stack_2{
	Node top;
	
	public void push(int d){
			Node n = new Node(d);
			n.next = top;
			top = n;
	}

	public Node pop(){
			if(top==null) return null;
			Node n = top;
			top = top.next;
			return n;
	}
	
	public int peek(){
		return top.data;
	}
	
	class Node{
			Node next;
			int data;
			public Node(int data) {
				super();
				this.data = data;
			}
	}
}
