package examples;

public class ParenthesesControl {

	public static void main(String[] args) {
		String expression1 =  "2*(i+5)*(7-j/(4*k))";
		String expression2 =  "2*(i+5*(7-j/(4*k))";
		Stack stack = new Stack();
		System.out.println(stack.checkParantheses(expression1)); //true
		System.out.println(stack.checkParantheses(expression2)); //false
	}

}

class Node{
	private String data;
	private Node next;
	
	public Node(String data) {
		this.data = data;
		next = null;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}

class Stack{
	private Node top;
	
	public Stack() {
		top = null;
	}
	
	public boolean stackIsNull() {
		if(top == null) return true;
		return false;
	}
	
	public void push(String data) {
		Node node = new Node(data);
		if(stackIsNull())
			top = node;
		else
		{
			node.setNext(top);
			top=node;
		}
	}
	
	public void pop() {
		
		if (stackIsNull()) System.out.println("Stack is null");
		
		else {
			top = top.getNext();
		}
	}
	
	public void print() {
		Node temp = top;
		while (temp != null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}
	
	public boolean checkParantheses(String expression) {
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '(') {
				push("(");
			}
			else {
				if (expression.charAt(i) == ')') {
					if (stackIsNull() || peek().equals(")")) {
						return false;
					} else {
						pop();
					}
				}
			}
		}
		
		if (stackIsNull()) {
			return true;
		} else {
			return false;
		}
	}
	
	private String peek() {
		if(stackIsNull()) 
			return null;
		else 
			return top.getData();
	}
}
