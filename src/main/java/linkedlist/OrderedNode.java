package linkedlist;

public class OrderedNode<K extends Comparable<K>> {
	private K value;
	private OrderedNode<K> next;
	
	public OrderedNode(K value) {
		this.setValue(value);
		this.setNext(null);
	}

	public K getValue() {
		return value;
	}

	public void setValue(K value) {
		this.value = value;
	}

	public OrderedNode<K> getNext() {
		return next;
	}

	public void setNext(OrderedNode<K> next) {
		this.next = next;
	}
}
