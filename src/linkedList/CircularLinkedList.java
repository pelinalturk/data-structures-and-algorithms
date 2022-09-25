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
		list.removeFromPos(2);
		list.print();
	}
}

 class CircularListNode {
	private int data;
    private CircularListNode next;
	
    public CircularListNode(int data) {
		this.data = data;
		this.next = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public CircularListNode getNext() {
		return next;
	}

	public void setNext(CircularListNode kuyruk) {
		this.next = kuyruk;
	}
}
class CircularLinkedListStructure{
	CircularListNode head;
	CircularListNode tail;

	public CircularLinkedListStructure() {
		head = null;
		tail = null;
	}
	
	void addToStart(int data) {
		CircularListNode node = new CircularListNode(data);
		
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
		CircularListNode node = new CircularListNode(data);

		if(head == null) {
			head = tail = node;
			tail.setNext(head);
		}
		else if(head != null && indis == 0)
			addToStart(data);
		else {
			CircularListNode temp = head;
			CircularListNode temp2 = temp;
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
		CircularListNode node = new CircularListNode(data);
		
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
			CircularListNode temp = head;
			CircularListNode temp2 = temp;
			int i = 0;
			while(temp.getNext() != head) {
			
				
				if(i == indis) {
					temp2.setNext(temp);
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
			CircularListNode temp = head;
			while(temp.getNext() != tail) {
				temp = temp.getNext();
			}
			
			temp.setNext(head.getNext());
			tail  = temp;
		}
	}
	
	void print() {
		
		CircularListNode temp = head;
		while(temp != tail) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
		System.out.println(temp.getData());
	}
}
