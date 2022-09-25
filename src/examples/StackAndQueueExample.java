package examples;

import java.util.Scanner;

//palindrom kelime bulma
public class StackAndQueueExample {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String word = scanner.nextLine();
		
		Stack stack = new Stack();
		Queue queue = new Queue();

		boolean control = true;
		
		for(int i = 0; i<word.length(); i++) {
			stack.push(word.charAt(i));
			queue.enQueue(word.charAt(i));			
		}
		
		while(!queue.isEmpty()) {
			if(stack.pop() != queue.deQueue())
			{
				control = false;
				break;
			}
		}
		System.out.println(control);
	}
}

class Node{
	char data;
	Node next;
	
	public Node(char data) {
		this.data = data;
		next = null;
	}
}
class Stack{
	Node top;
	
	public Stack() {
		top = null;
	}
	public void push(char data) {
		Node node = new Node(data);
		
		if(top==null) {
			top = node;
		}
		else {
			node.next = top;
			top = node;
		}
	}
	
	public char pop() {
		if(top == null)
			return 's';
		
		char ch = top.data;
		top = top.next;
		return ch;
	}
	
	public boolean isEmpty() {
		return top == null ? true: false;
	}
	
	public void print() {
		Node temp = top;
		
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}

class Queue{//ilk giren ilk cikar
	Node front;
	Node rear;
	
	public Queue() {
		front = null;
		rear = null;
	}
	
	public void enQueue(char data) {
		Node node = new Node(data);
		
		if(front == null) {
			front = rear = node;
		}
		else {
			rear.next = node;
			rear= node;
		}
	}
	
	public char deQueue() {
		
		if(front == null)
		{
			return 's';
		}
		char ch = front.data;
		front = front.next;
		return ch;
	}
	
	public boolean isEmpty() {
		return front == null ? true: false;
	}
	
	public void print() {
		Node temp = front;
		
		while(temp != rear) {
			System.out.println(temp.data);
			temp = temp.next;
		}
		System.out.println(temp.data);
	}
}
