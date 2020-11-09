package linkedlist;

public class Node<K> implements INode<K>{
	private K key;
	private INode<K> next;
	
	public Node(K key) {
		this.setKey(key);
		this.setNext(null);
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public INode<K> getNext() {
		return next;
	}

	public void setNext(INode<K> next) {
		this.next = next;
	}

}
