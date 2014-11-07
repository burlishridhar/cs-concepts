package StacksAndQueues;

public class QueueWithTwoStacks {
	Stack_ID3 inbox, outbox;
	
	public QueueWithTwoStacks(){
		inbox = new Stack_ID3(); outbox = new Stack_ID3();
	}

	public void enqueue(int d){
			inbox.push(d);
	}
	
	public Node_ID1 dequeue(){
		 if(!outbox.isEmpty()) return outbox.pop();
		 if(inbox.isEmpty()) return null;
		 while(!inbox.isEmpty())
			 	outbox.push(inbox.pop().data);
		 return outbox.pop();
	}
	
	public void printQueue(){
		System.out.println("\nOutbox:");
		outbox.printStack();
		System.out.println("\nInbox:");
		inbox.printStack();
	}
	
	public static void main(String[] args) {
			QueueWithTwoStacks q = new QueueWithTwoStacks();
			
			q.enqueue(1);
			q.enqueue(2);
			q.enqueue(3);
			q.enqueue(4);
			
			q.dequeue();
						
			q.printQueue();
	}

}

class Stack_ID3{
	Node_ID1 top;
	
	public void push(int d){
		Node_ID1 n = new Node_ID1(d); n.next = top;
		top = n;
	}
	
	public Node_ID1 pop(){
			if(top==null) return null;
			Node_ID1 n = top; top=top.next;
			return n;
	}
	
	public boolean isEmpty(){
		return top==null;
	}
	
	public void printStack(){
		Node_ID1 n = top;
		while(n!=null){
				System.out.println("\tValue : " + n.data);
				n=n.next;
		}
	}
}

class Node_ID1{
	Node_ID1 next;
	int data;
	public Node_ID1(int data) {
		super();
		this.data = data;
	}
	
}