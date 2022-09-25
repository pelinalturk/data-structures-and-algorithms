package linkedList;

//tek yonlu dogrusal bagli liste
public class SinglyLinkedList {

	public static void main(String[] args) {
		
		List list = new List();
		list.addToEnd(10);
		list.addToEnd(30);
		list.addToStart(5);
		list.addToStart(4);
		list.insertAtPos(2, 7);
		list.removeFromEnd();
		list.removeFromStart();
		list.removeFromPos(2);
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

	public void setNext(Node kuyruk) {
		this.next = kuyruk;
	}
}

class List{
	
	Node head;
	
	public List() {
		head  = null;
	}

	void addToStart(int data) {
		Node node = new Node(data);
		
		if(head == null) {
			head = node;
			
		}else{
			
			node.setNext(head);
			head = node;
		}
	}
	
	void addToEnd(int data) {
		
		Node node = new Node(data);
		
		if(head == null) {
			head = node;
			
		}else {
			
			Node temp = head;
			
			while(temp.getNext() != null) {
				temp = temp.getNext();
			}
			
			temp.setNext(node);
		}
	}
	
	void insertAtPos(int pos, int data) {
		Node node =  new Node(data);
		
		if(head == null && pos == 0) 
			head = node;
		
		else if(head != null && pos == 0)
			addToStart(data);
		
		else {
			int i = 0;
			Node temp = head;
			Node temp2 = temp;
			
			while(temp.getNext() != null) {
				 temp2= temp;
				 temp = temp.getNext();
				 
				 if(i == pos) {
					 temp2.setNext(node);
					 node.setNext(temp);
				 }
				 i++;
			}
			if(i == pos) {
				 temp2.setNext(temp);
				 temp.setNext(node);
			 }
		}
	}
	
	void removeFromStart() {
		if(head == null) {
			System.out.println("List is null");
		}else if(head.getNext() == null) {
			head = null;
		}else {
			head = head.getNext();
		}
	}
	
	void removeFromPos(int indis) {
		if(head == null)
			System.out.println("List is null");
		else if(head.getNext() == null && indis == 0)
			head = null;
		else if(head != null && indis == 0)
			removeFromStart();
		else {
			Node temp = head;
			Node temp2= temp;
			int i = 0;
			
			while(temp.getNext() != null) {
				if(i == indis) {
					temp2.setNext(temp.getNext());
					
				}
				i++;
				temp2 = temp;
				temp = temp.getNext();
			}
			if(i == indis) {
				removeFromEnd();
			}
		}
	}
	
	void removeFromEnd() {
		if(head == null) {
			System.out.println("List is null");
		}else if(head.getNext() == null) {
			head = null;
		}else {
			Node temp = head;
			Node onceki = temp;
			
			while(temp.getNext() != null) {
				onceki = temp;
				temp = temp.getNext();
			}
			onceki.setNext(null);
		}
	}
	
	void print() {
		
		Node temp = head;
		
		if(head == null)
			System.out.println("List is null");
		
		while(temp != null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}
}
