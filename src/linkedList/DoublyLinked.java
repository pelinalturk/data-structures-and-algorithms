package linkedList;

//cift yonlu dogrusal bagli liste
public class DoublyLinked {
	public static void main(String[] args) {
		
		DoublyLinkedList list = new DoublyLinkedList();
		list.addToStart(5);
		list.addToEnd(10);
		list.addToEnd(20);
		list.insertAtPos(1, 15);

		
		list.print();
		System.out.println("------Print In Reverse------");
		list.printInReverse();
	}
}

class DoublyLinkedListNode{
	private int data;
	private DoublyLinkedListNode prev;
    private DoublyLinkedListNode next;
	
    public DoublyLinkedListNode(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public DoublyLinkedListNode getNext() {
		return next;
	}

	public void setNext(DoublyLinkedListNode next) {
		this.next = next;
	}
	
	public DoublyLinkedListNode getPrev() {
		return prev;
	}
	public void setPrev(DoublyLinkedListNode prev) {
		this.prev = prev;
	}
}

class DoublyLinkedList{
	
	DoublyLinkedListNode head;
	DoublyLinkedListNode tail;
	
	
	public DoublyLinkedList() {
		head = null;
		tail = null;
	}

	void addToStart(int data) {
		
		DoublyLinkedListNode node = new DoublyLinkedListNode(data);
		
		if(head == null) {
			head = tail = node;
		}
		else {
			node.setNext(head);
			head.setPrev(node);
			head = node;
		}
	}
	
	void addToEnd(int data) {
		
		DoublyLinkedListNode node = new DoublyLinkedListNode(data);

		if(head == null) {
			head = tail = node;
		}
		else {
			tail.setNext(node);
			node.setPrev(tail);
			tail = node;
		}
	}
	
	void insertAtPos(int indis, int data) {
		
		DoublyLinkedListNode node = new DoublyLinkedListNode(data);

		if(head == null) {
			head = tail = node;
		}
		else if(head != null && indis == 0) {
			addToStart(data);
		}
		else {
			DoublyLinkedListNode tail = head; //anlik indis
			DoublyLinkedListNode temp = tail;//onceki
			int i = 0;
			
			while(tail.getNext() != null) {
				temp = tail;
				tail = tail.getNext();
				
				if(i == indis) {
					temp.setNext(node);
					node.setNext(tail);
					node.setPrev(temp);
					tail.setPrev(node);
				}
				i++;
			}
			if(i == indis) {
				addToEnd(data);
			}
		}
	}
	
	void removeFromStart() {
		if(head == null)
			System.out.println("List is null");
		else if(head.getNext() == null)
			head= tail = null;
		else {
			head.setNext(head.getNext());
			head.setPrev(null);
		}		
	}
	
	void removeFromPos(int indis) {
		if(head == null)
			System.out.println("List is null");
		else if(head.getNext() == null && indis == 0)
			head =null;
		else {
			DoublyLinkedListNode tail = head;
			DoublyLinkedListNode temp = tail;
			int i = 0;
			
			while(tail.getNext() != null) {
				temp = tail;
				tail.setNext(tail.getNext());
				i++;
				
				if(i == indis) {
					temp.setNext(tail.getNext());
					
					tail.getNext().setPrev(temp);

				}
			}
			if(i == indis) {
				removeFromEnd();
			}
		}
	}
	
	void removeFromEnd() {
		if(head == null)
			System.out.println("List is null");
		else {
			tail.setNext(tail.getPrev());
			tail.setNext(null);
		}
	}
	
	void print() {
		
		DoublyLinkedListNode temp = head;
		while(temp.getNext() != null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
		System.out.println(temp.getData());
	}
	
	void printInReverse() {
		DoublyLinkedListNode temp = tail;
		while(temp.getPrev() != null) {
			System.out.println(temp.getData());
			temp = temp.getPrev();
		}
		System.out.println(temp.getData());
	}
}
