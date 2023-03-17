package linkedList;

//tek yonlu dairesel liste
public class CircularLinkedList {
	public static void main(String[] args) {
		
		CircularLinkedListStructure list = new CircularLinkedListStructure();
		list.addToStart(5);
		list.addToEnd(10);
		list.addToEnd(20);
		list.addToEnd(30);
		list.addToEnd(15);
		list.insertAtPos(2, 13);
		list.print();
		
		System.out.println("-------");
		list.removeFromPos(3);
		list.print();
	}
}

 class Node {
	private int data;
    private Node next;
	
    public Node(int data) {
		this.data = data;
		this.next = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
class CircularLinkedListStructure{
	Node head;
	Node tail;

	public CircularLinkedListStructure() {
		head = null;
		tail = null;
	}
	
	void addToStart(int data) {
		Node node = new Node(data);
		
		if(head == null) {
			head = tail = node;
			tail.setNext(head);
		}
		else {
			node.setNext(head);
			head = node;
			tail.setNext(head);
		}
	}
	
	void insertAtPos(int indis, int data) {
		Node node = new Node(data);

		if(head == null) {
			head = tail = node;
			tail.setNext(head);
		}
		else if(head != null && indis == 0)
			addToStart(data);
		else {
			Node temp = head;
			Node temp2 = temp;
			int i = 0;
			
			while(temp.getNext() != head) {
				
				
				if(indis == i) {
					temp2.setNext(node);
					node.setNext(temp);
				}
				temp2 = temp;
				temp = temp.getNext();
				i++;
				
			}
			if(indis == i) {
				addToEnd(data);
			}
		}
	}
	
	void addToEnd(int data) {
		Node node = new Node(data);
		
		if(head == null) {
			head = tail = node;
			tail.setNext(head);
		}else {
			tail.setNext(node);
			tail = node;
			tail.setNext(head);
		}
	}
	
	void removeFromStart(){
		if(head == null) {
			System.out.println("list is null");
		}
		else if(head == tail)
			head = tail = null;
		else {
			head = head.getNext();
			tail.setNext(head);
		}
	}
	
	void removeFromPos(int indis) {
		
		if(head == null) {
			head = tail;
			tail.setNext(head);
		}
		else if(head != null && indis == 0) {
			removeFromStart();
		}
		else {
			Node temp = head;
			Node temp2 = temp;
			int i = 0;
			while(temp.getNext() != head) {
			
				
				if(i == indis) {
					temp2.setNext(temp.getNext());
				}
				temp2 = temp;
				temp = temp.getNext();
				
				i++;
			}
			if(i == indis) {
				removeFromEnd();
			}
		}
	}
		
	void removeFromEnd() {
		if(head == null) {
			System.out.println("list is null");
		}else {
			Node temp = head;
			while(temp.getNext() != tail) {
				temp = temp.getNext();
			}
			
			temp.setNext(head.getNext());
			tail  = temp;
		}
	}
	
	void print() {
		
		Node temp = head;
		while(temp != tail) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
		System.out.println(temp.getData());
	}
}
