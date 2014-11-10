package stacksAndQueues;

public class SortStack {
	Stack_ID4 stack;
	
	public SortStack(){
			stack = new Stack_ID4();
	}
	
	public void printStack(){
		Node_ID2 n = stack.top;
		while(n!=null){
				System.out.println("\tValue : "+n.data);
				n=n.next;
		}
		
	}
	
	public Stack_ID4 sort(Stack_ID4 stack){
			if(stack.isEmpty()) return stack;
			Node_ID2 pivot = stack.pop();
			Stack_ID4 left = new Stack_ID4();
			Stack_ID4 right = new Stack_ID4();
			
			while(!stack.isEmpty()){
					Node_ID2 node = stack.pop();
					if(node.data<pivot.data) left.push(node.data);
					else right.push(node.data);
			}
			sort(left); sort(right);
			
			Stack_ID4 temp = new Stack_ID4();
			while(!right.isEmpty()) temp.push(right.pop().data);
			temp.push(pivot.data);
			while(!left.isEmpty()) temp.push(left.pop().data);
			
			while(!temp.isEmpty()) stack.push(temp.pop().data);
			
			return stack;
		
	}
	
	public static void main(String[] args) {
			SortStack s = new SortStack();
			s.stack.push(3);
			s.stack.push(111);
			s.stack.push(12);
			s.stack.push(7);
			s.stack.push(5);
			
			System.out.println("Original Stack:");
			s.printStack();
			System.out.println("Sorted Stack:");
			s.sort(s.stack);
			s.printStack();
			
			
			
	}

}

class Stack_ID4{
	Node_ID2 top;
	
	public void push(int d){
			Node_ID2 n = new Node_ID2(d);
			n.next = top; top = n;
	}

	public Node_ID2 pop(){
		if(top==null) return null;
		Node_ID2 n = top; top=top.next;
		return n;
	}
	
	public Node_ID2 peek(){
		return top;
	}
	
	public boolean isEmpty(){
		return top==null;
	}
}

class Node_ID2{
	 int data;
	 Node_ID2 next;
	public Node_ID2(int data) {
		super();
		this.data = data;
	}
	 
}