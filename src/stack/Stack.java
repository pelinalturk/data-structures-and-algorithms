package stack;

//son giren ilk cikar
public class Stack {
	public static void main(String[] args) {
		StackStructure structure = new StackStructure();
		structure.push(5);
		structure.push(10);
		structure.print();
		System.out.println("--");
		structure.pop();
		structure.print();
	}
}

class Node{
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}
class StackStructure{
	Node top;
	
	public StackStructure() {
		this.top = null;
	}
	
	public void push(int data) {
		Node node = new Node(data);
		
		if(top == null) {
			top = node;
		}
		else {
			node.next = top;
			top = node;
		}
	}
	
	public int pop() {
		if(top == null)
			return -1;

		int popNumber=top.data;
		top = top.next;
		
		return popNumber;
	}
	
	public void print() {
		
		Node temp = top;
		
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}
