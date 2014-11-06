package StacksAndQueues;

import java.util.ArrayList;

public class SetOfStacks {

	ArrayList<Stack_ID1> list = new ArrayList<Stack_ID1>();
	
	public void push(int d){
			Stack_ID1 last =null;
			if(!list.isEmpty()) last = list.get(list.size()-1);
			
			if(last!=null && !last.isAtCapacity()) last.push(d);
			else{
					Stack_ID1 s = new Stack_ID1(); s.push(d);
					list.add(s);
			}
	}
	
	public int pop(){
			Stack_ID1 last = list.get(list.size()-1);
			int val = last.pop().data;
			if(last.isEmpty()) list.remove(list.size()-1);
			return val;
	}
	
	public void printAllStacks(){
		for(Stack_ID1 s:list) s.printStack();
	}
	
	public static void main(String[] args) {
			SetOfStacks s = new SetOfStacks();
			s.push(1);
			s.push(2);
			s.push(3);
			s.push(4);
			s.push(5);
			
			s.printAllStacks();
			
			s.pop(); s.pop();
			
			s.printAllStacks();
			
	}

}

class Stack_ID1{
	Node top;
	int size;
	int limit;
	
	public Stack_ID1() {
		size=0; limit=3;
	}

	public void push(int d){
			if(size==limit) return;
			Node n = new Node(d); n.next = top;
			top=n;
			size++;
	}

	public Node pop(){
			if(top==null) return null;
			Node n = top; top=top.next;
			size--;
			return n;
	}

	public boolean isAtCapacity(){
		return size==limit;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public void printStack(){
		System.out.println("\nStack :");
		Node n = top;
		while(n!=null){
				System.out.println("\tValue : "+n.data);
				n=n.next;
		}
	}
	
	class Node{
		int data;
		Node next;
		public Node(int data) {
			super();
			this.data = data;
		}
		
	}
}