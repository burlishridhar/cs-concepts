package StacksAndQueues;

public class TowerOfHanoi {
	Stack_ID2 A, B, C;
	
	public TowerOfHanoi(int rings){
			A = new Stack_ID2(); B = new Stack_ID2(); C = new Stack_ID2();
			for(int i=rings-1; i>=0; i--) A.push(i);
	}

	public void moveRing(int ring, Stack_ID2 source, Stack_ID2 dest, Stack_ID2 spare){
		if(ring==0) dest.push(source.pop().data);
		else{
				moveRing(ring-1, source, spare, dest);
				dest.push(source.pop().data);
				moveRing(ring-1, spare, dest, source);
		}
	}
	
	public void printAllStacks(){
		System.out.println("Stack A"); A.printStack();
		System.out.println("Stack B"); B.printStack();
		System.out.println("Stack C"); C.printStack();
		
	}
	
	public static void main(String[] args) {
		int numberOfRings = 6;
		TowerOfHanoi t = new TowerOfHanoi(numberOfRings);
		
		System.out.println("Before:");
		t.printAllStacks();
		System.out.println("\nAfter:");
		t.moveRing(numberOfRings -1, t.A, t.C, t.B);
		t.printAllStacks();

	}

}

class Stack_ID2{
	Node top;
	public void push(int d){
			Node n=new Node(d); n.next = top;
			top = n;
	}
	
	public Node pop(){
		if(top==null) return null;
		Node n = top; top=top.next;
		return n;
	}
	
	public void printStack(){
		Node n = top;
		while(n!=null){
				System.out.println("\tValue : "+n.data);
				n=n.next;
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
