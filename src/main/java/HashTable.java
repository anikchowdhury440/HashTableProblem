import java.util.ArrayList;

import linkedlist.*;

public class HashTable<K, V> {
	private final int numBuckets;
	ArrayList<LinkedList<K>> myBucketArray;
	
	public HashTable() {
		this.numBuckets = 10;
		this.myBucketArray = new ArrayList<>(numBuckets);
		for(int i = 0; i < numBuckets; i++) {
			this.myBucketArray.add(null);
		}
	}

	public int getBucketIndex(K key) {
		int hashcode = Math.abs(key.hashCode());
		int index = hashcode % numBuckets;
		return index;
	}
	
	public V get(K key) {
		int index = this.getBucketIndex(key);
		LinkedList<K> linkedList = this.myBucketArray.get(index);
		if(linkedList == null) {
			return null;
		}
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) linkedList.search(key);
		if(myMapNode == null) {
			return null;
		}
		else {
			return myMapNode.getValue();
		}
	}

	public void add(K key, V value) {
		int index = this.getBucketIndex(key);
		LinkedList<K> linkedList = this.myBucketArray.get(index);
		if(linkedList == null) {
			linkedList = new LinkedList<>();
			this.myBucketArray.set(index, linkedList);
		}
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) linkedList.search(key);
		if(myMapNode == null) {
			myMapNode = new MyMapNode<K, V>(key, value);
			linkedList.append(myMapNode);
		}
		else {
			myMapNode.setValue(value);
		}
	}
	
	@Override
	public String toString() {
		return "" + myBucketArray + "";
	}
}
