import linkedlist.*;

public class HashTable<K, V> {
	LinkedList<K> linkedList;
	
	public HashTable() {
		this.linkedList = new LinkedList<>();
	}

	public V get(K key) {
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) this.linkedList.search(key);
		if(myMapNode == null) {
			return null;
		}
		else {
			return myMapNode.getValue();
		}
	}

	public void add(K key, V value) {
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) this.linkedList.search(key);
		if(myMapNode == null) {
			myMapNode = new MyMapNode<K, V>(key, value);
			this.linkedList.append(myMapNode);
		}
		else {
			myMapNode.setValue(value);
		}
	}
	
	public void printHashTable() {
		linkedList.printNodes();
	}
	
}
