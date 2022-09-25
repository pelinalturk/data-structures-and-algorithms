package queue;

//First in first out
//ekleme islemi sona yapilir
//cikartma islemi bastan yapilir
public class Queue {
	public static void main(String[] args) {
		QueueStructure structure = new QueueStructure();
		structure.enQueue(50);
		structure.enQueue(40);
		structure.enQueue(30);
		structure.deQueue();
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

class QueueStructure{
	Node front;
	Node rear;
	
	public QueueStructure() {
		front = null;
		rear = null;
	}
	
	public void enQueue(int data) {
		Node node = new Node(data);
		
		if(front == null) {
			front = rear = node;
		}
		else {
			rear.next = node;
			rear = node;
		}
	}
	
	public int deQueue() {
		
		if(front == null) {
			front = rear = null;
			return -1;
		}
		int deQueueNumber = front.data;
		front = front.next;
		return deQueueNumber;
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
