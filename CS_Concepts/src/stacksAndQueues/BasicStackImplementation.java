package stacksAndQueues;

public class BasicStackImplementation {

	public static void main(String[] args) {
			BasicStackImplementation b= new BasicStackImplementation();
			Stack s= b.new Stack();
			
			s.push(1);
			s.push(2);
			s.push(3);
			
			s.printStack();
	}

	class Stack{
		Node top;
		public Node pop(){
			if(top==null) return null;
			Node item = top; top = top.next;
			return item;
		}

		public void push(int d){
			Node n = new Node(d);
			n.next = top;
			top = n;
		}
	
		public void printStack(){
			if(top==null) return;
			Node n=top;
			while(n!=null){
					System.out.println("Value : "+n.data);
					n=n.next;
			}
		}
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
