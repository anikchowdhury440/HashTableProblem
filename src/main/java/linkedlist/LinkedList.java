package linkedlist;

public class LinkedList<K> {
	public INode<K> head;
	public INode<K> tail;
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	public boolean isEmpty() {
		if(this.tail == null && this.head == null) {
			return true;
		}
		return false;
	}
	
	public void add(INode<K> newNode) {
		if(isEmpty()) {
			this.tail = newNode;
			this.head = newNode;
		}
		else {
			INode<K> tempNode = this.head;
			this.head = newNode;
			this.head.setNext(tempNode);
		}
	}
	
	public void append(INode<K> newNode) {
		if(isEmpty()) {
			this.tail = newNode;
			this.head = newNode;
		}
		else {
			this.tail.setNext(newNode);
			this.tail = newNode;
		}
	}
	
	public void insert(INode<K> node, INode<K> newNode) {
		
		INode<K> tempNode = search(node.getKey());
		if(tempNode != null) {
			newNode.setNext(tempNode.getNext());
			tempNode.setNext(newNode);
		}
		else {
			System.out.println("Node can't inserted");
		}
	}
	
	public INode<K> pop() {
		INode<K> tempNode = this.head;
		if(head.equals(tail)) {
			this.tail = null;
			this.head = null;
			return tempNode;
		}
		this.head = head.getNext();
		return tempNode;
	}

	public INode<K> popLast() {
		INode<K> tempNode = this.head;
		if(head.equals(tail)) {
			this.tail = null;
			this.head = null;
			return tempNode;
		}
		INode<K> removedNode = this.tail;
		while(tempNode.getNext() != this.tail)
		{
			tempNode = tempNode.getNext();
		}
		tempNode.setNext(null);
		this.tail = tempNode;
		return removedNode;
	}
	
	public INode<K> search(K key) {
		INode<K> tempNode = this.head;
		while(tempNode != null && tempNode.getNext() != null) {
			if(tempNode.getKey().equals(key)) {
				return tempNode;
			}
			tempNode = tempNode.getNext();
		}
		return null;
	}
	
	public void delete(INode<K> node) {
		
		INode<K> removedNode = search(node.getKey());
		if(removedNode != null) {
			INode<K> tempNode = this.head;
			while(tempNode.getNext() !=  removedNode) {
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(removedNode.getNext());
			System.out.println("After Deleting Size = " + size());
		}
		else {
			System.out.println("Node can't deleted");
		}
	}

	public int size() {
		int count = 0;
		INode<K> tempNode = this.head;
		if(tempNode == null) {
			return count;
		}
		count++;
		while(tempNode.getNext() != this.tail) {
			tempNode = tempNode.getNext();
			count++;
		}
		tempNode = tempNode.getNext();
		count++;
		return count;
	}
	
	public void printNodes() {
		System.out.println(head);
	}

}
