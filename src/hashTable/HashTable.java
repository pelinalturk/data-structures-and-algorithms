package hashTable;

public class HashTable {
	public static void main(String[] args) {
		HashTableStructure structure = new HashTableStructure(5);
		structure.put(10, 5); //0
		structure.put(7, 6); //2
		structure.put(2, 15); //2
		structure.put(1, 18); //1
		structure.put(12, 2); //2
		structure.put(4, 4);
		System.out.println(structure.get(7));
		structure.remove(2);
		structure.print();
	}
}

class Node{
	
	private int key;
	private int value;
	private Node next;
	
	public Node() {
		next = null;
	}
	
	public Node(int key, int value) {
		this.key = key;
		this.value = value;
		next = null;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}	
}

class HashTableStructure{
	private int size;
	public Node[] array;
	
	public HashTableStructure(int size) {
		this.size = size;
		array = new Node[size];
		
		for(int i = 0; i<size; i++) {
			array[i] = new Node();
		}
	}
	
	private int hash(int key) {
		return key % size;
	}
	
	void put(int key, int value) {
		int hash = hash(key);
		Node node = new Node(key, value);
		Node temp = array[hash];
		
		while(temp.getNext() != null) 
			temp = temp.getNext();//bulundugu indis üzerindeki bagli listenin sonuncu elemanina ulasir
		
		temp.setNext(node); //son elemanin gostericisi ile yeni node gosterildi
	}
	
	int get(int key) {
		
		int hash = hash(key);
		Node temp = array[hash];

		if(array[hash] == null)
			return -1;
		else {
			while(temp != null && temp.getKey() != key)
				temp = temp.getNext();
			}
		return temp.getValue();
	}
	
	void remove(int key) {
		
		int hash = hash(key);
		
		Node temp = array[hash];
		Node temp2 = array[hash];
		
		if(temp.getNext().getNext() ==null && temp.getNext().getKey() == key)// silinecek olan ilk eleman ise
			{
				System.out.println(temp.getNext().getValue() + " deleted");
				temp.setNext(null);
			}
		else{
			
			while(temp != null) {
				if(temp.getKey() == key) {
					temp2.setNext(temp.getNext());
					System.out.println(temp.getValue() + " deleted");
				}
				temp2 = temp;
				temp = temp.getNext();
			}
			
		}
	}
	
	void print() {
		
		for(int i = 0; i < size; i++) {
			Node temp = array[i];
			
			if(temp.getNext() != null)
			{
				System.out.print("Array[" + i + "] -> ");
				while(temp.getNext() != null) {
					System.out.print(temp.getNext().getKey() + "|" + temp.getNext().getValue() + " -> ");
					temp = temp.getNext();
				}
				System.out.println();
			}
			else
				System.out.println("Array[" + i + "] -> ");
		}
	}
}

