package tree;

//Binary Tree
public class BTree {
	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 8);
		tree.root = tree.insert(tree.root, 15);
		tree.root = tree.insert(tree.root, 5);
		tree.root = tree.insert(tree.root, 12);
		tree.root = tree.insert(tree.root, 20);
		tree.root = tree.insert(tree.root, 9);
		tree.root = tree.insert(tree.root, 25);
		
		tree.preOrder(tree.root); // 10 8 5 9 15 12 20 25  
		
		System.out.println();
		
		tree.inOrder(tree.root); //5 8 9 10 12 15 20 25
		
		System.out.println();
		
		tree.postOrder(tree.root); //5 9 8 12 25 20 15 10 
		
		System.out.println("\n" + tree.height(tree.root)); //3
		
		System.out.print(tree.size(tree.root)); //8
	}
}

class Node{
	int data;
	Node left;
	Node right;
	
	public Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class Tree{
	
	Node root;
	
	public Tree() {
		root = null;
	}
	
	public Node newNode(int data) {
		root = new Node(data);
		return root;
	}
	
	Node insert(Node root, int data) {
		if(root != null) {
			if(data < root.data)
				root.left = insert(root.left, data);
			else
				root.right = insert(root.right, data);
		}
		else
			root = newNode(data);
		
		return root;
	}
	
	void preOrder(Node root) {
		if(root != null) {
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	void inOrder(Node root) {
		if(root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}
	
	void postOrder(Node root) {
		if(root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + " ");
		}
	}
	
	int height(Node root) {
		if(root == null)
			return -1;
		else {
			int left = 0, right = 0;
			left = height(root.left);
			right = height(root.right);
			
			if(left > right)
				return left + 1;
			else
			return right + 1;
		}
	}
	
	int size(Node root) {
		if(root == null)
			return 0;
		else
			return size(root.left) + 1 + size(root.right);
	}
}
