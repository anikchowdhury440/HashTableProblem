package linkedlist;

public class OrderedLinkedList<K extends Comparable<K>> {
	public OrderedNode<K> head;
	public OrderedNode<K> tail;
	
	public OrderedLinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	public boolean isEmpty() {
		if(this.tail == null && this.head == null) {
			return true;
		}
		return false;
	}
	
	public void add(OrderedNode<K> newNode) {
		if(isEmpty()) {
			this.tail = newNode;
			this.head = newNode;
		}
		else if(newNode.getValue().compareTo(this.tail.getValue()) >= 0) {
			this.tail.setNext(newNode);
			this.tail = newNode;
		}
		else if(newNode.getValue().compareTo(this.head.getValue()) <= 0) {
			OrderedNode<K> tempNode = this.head;
			this.head = newNode;
			this.head.setNext(tempNode);
		}
		else {
			OrderedNode<K> tempNode = this.head;
			while(newNode.getValue().compareTo(tempNode.getNext().getValue()) >= 0) {
				tempNode = tempNode.getNext();
			}
			newNode.setNext(tempNode.getNext());
			tempNode.setNext(newNode);
		}
	}
	
	public void printNodes() {
		StringBuffer myNodes = new StringBuffer();
		if(isEmpty()) {
			return;
		}
		OrderedNode<K> tempNode = this.head;
		while(tempNode.getNext() != null) {
			myNodes.append(tempNode.getValue());
			if(!tempNode.equals(this.tail)) {
				myNodes.append("->");
			}
			tempNode = tempNode.getNext();
		}
		myNodes.append(tempNode.getValue());
		System.out.println(myNodes);
	}
}
