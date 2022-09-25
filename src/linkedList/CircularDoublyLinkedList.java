package linkedList;

//cift yonlu dairesel bagli liste
public class CircularDoublyLinkedList {
	public static void main(String[] args) {
		CircularDoublyLinkedListStructure list = new CircularDoublyLinkedListStructure();
		list.addToStart(10);
		list.addToStart(5);
		list.addToEnd(15);
		list.addToEnd(30);
		list.insertAtPos(2, 20);
		list.removeFromEnd();
		list.removeFromPos(2);
		list.removeFromStart();
		list.print();
	}
}

class CircularDoublyListNode{
	private int data;
    private CircularDoublyListNode next;
    private CircularDoublyListNode prev;
    
    public CircularDoublyListNode(int data) {
		this.data = data;
		this.next = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public CircularDoublyListNode getNext() {
		return next;
	}

	public void setNext(CircularDoublyListNode next) {
		this.next = next;
	}

	public CircularDoublyListNode getPrev() {
		return prev;
	}

	public void setPrev(CircularDoublyListNode prev) {
		this.prev = prev;
	}
	
	
}

class CircularDoublyLinkedListStructure{
	private CircularDoublyListNode head;
	private CircularDoublyListNode tail;
	
	public CircularDoublyLinkedListStructure() {
		this.head = null;
		this.tail = null;
	}
	
	void addToStart(int data) {
		
		CircularDoublyListNode node = new CircularDoublyListNode(data);
		if(head == null)
		{
			head = tail  = node;
			tail.setNext(head);
			tail.setPrev(head);
			head.setNext(tail);
			head.setPrev(tail);
			
		}else {
			node.setNext(head);
			head.setPrev(node);
			head = node;
			head.setPrev(tail);
			tail.setNext(head);
		}
	}
	
	void insertAtPos(int pos, int data) {
		CircularDoublyListNode node = new CircularDoublyListNode(data);
		
		if(head == null && pos == 0) {
			head = tail  = node;
			tail.setNext(head);
			tail.setPrev(head);
			head.setNext(tail);
			head.setPrev(tail);
		
		}else if(head != null && pos == 0) {
			addToStart(data);
		
		}else {
			int i = 0;
			CircularDoublyListNode temp = head;
			CircularDoublyListNode temp2 = temp;
			
			while(temp != tail) {
				if(i == pos) {
					temp2.setNext(node);
					node.setPrev(temp2);
					node.setNext(temp);
					temp.setPrev(node);
					i++;
					break;
				}
				
				temp2 = temp;
				temp = temp.getNext();
				i++;
			}
			if(i == pos) {
				addToEnd(data);
			}
		}
	}
	void addToEnd(int data) {
		
		CircularDoublyListNode node = new CircularDoublyListNode(data);
		if(head == null)
		{
			head = tail  = node;
			tail.setNext(head);
			tail.setPrev(head);
			head.setNext(tail);
			head.setPrev(tail);
			
		}else {
			tail.setNext(node);
			node.setPrev(tail);
			tail = node;
			tail.setNext(head);
			head.setPrev(tail);
		}
	}
	
	void removeFromStart() {
		if(head == null) {
			System.out.println("List is null");
		}
		else if(head.getNext() == head) {
			head = tail = null;
		}
		else {
			head = head.getNext();
			head.setPrev(tail);
			tail.setNext(head);
			
		}
	}
	
	void removeFromPos(int pos) {
		if(head == null) {
			System.out.println("List is null");
		}
		
		else if(head.getNext() == head && pos == 0) {
			head = tail = null;
		}
		
		else if(head.getNext() != head && pos == 0){
			removeFromStart();
		
		}else {
			int i = 0;
			CircularDoublyListNode temp = head;
			CircularDoublyListNode temp2 = temp;
			
			while(temp != tail) {
				if(i == pos) {
					temp2.setNext(temp.getNext());
					temp.getNext().setPrev(temp2);
				}
				
				temp2 = temp;
				temp = temp.getNext();
				i++;
			}
			if(i == pos) {
				removeFromEnd();
			}
		}
	}
	
	void removeFromEnd() {
		if(head == null) {
			System.out.println("List is null");
		}
		else if(head.getNext() == head) {
			head = tail = null;
		}
		else {
			tail = tail.getPrev();
			tail.setNext(head);
			head.setPrev(tail);
		}
	}
	

	void print() {
		
		CircularDoublyListNode temp = head;
		
		while(temp.getNext() != head) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
		System.out.println(temp.getData());
	}
}