package linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {
	
	@Test
	public void givenThreeNumbers_WhenLinked_ShouldPassesLinkedListTest() {
		Node<Integer> firstNode = new Node<Integer>(56);
		Node<Integer> secondNode = new Node<Integer>(30);
		Node<Integer> thirdNode = new Node<Integer>(70);
		firstNode.setNext(secondNode);
		secondNode.setNext(thirdNode);
		boolean result = firstNode.getNext().equals(secondNode) &&
						 firstNode.getNext().getNext().equals(thirdNode);
		Assert.assertTrue(result);
	}
	
	@Test
	public void givenThreeNumbers_WhenAddedToLinkedList_ShouldBeAddedToTop() {
		Node<Integer> firstNode = new Node<Integer>(70);
		Node<Integer> secondNode = new Node<Integer>(30);
		Node<Integer> thirdNode = new Node<Integer>(56);
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(firstNode);
		linkedList.add(secondNode);
		linkedList.add(thirdNode);
		linkedList.printNodes();
		boolean result = linkedList.head.equals(thirdNode) &&
						 linkedList.head.getNext().equals(secondNode) &&
						 linkedList.tail.equals(firstNode);
		Assert.assertTrue(result);
	}
	
	@Test
	public void givenThreeNumbers_WhenAppendToLinkedList_ShouldBeAddedToLast() {
		Node<Integer> firstNode = new Node<Integer>(56);
		Node<Integer> secondNode = new Node<Integer>(30);
		Node<Integer> thirdNode = new Node<Integer>(70);
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(firstNode);
		linkedList.append(secondNode);
		linkedList.append(thirdNode);
		linkedList.printNodes();
		boolean result = linkedList.head.equals(firstNode) &&
						 linkedList.head.getNext().equals(secondNode) &&
						 linkedList.tail.equals(thirdNode);
		Assert.assertTrue(result);
	}

	@Test
	public void givenNumber_WhenInsertedBetweenTwoNumberInLinkedList_ShouldBeInsertedInBetween() {
		Node<Integer> firstNode = new Node<Integer>(56);
		Node<Integer> secondNode = new Node<Integer>(70);
		Node<Integer> insertedNode = new Node<Integer>(30);
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(firstNode);
		linkedList.append(secondNode);
		linkedList.printNodes();
		linkedList.insert(firstNode, insertedNode);
		linkedList.printNodes();
		boolean result = linkedList.head.equals(firstNode) &&
				 linkedList.head.getNext().equals(insertedNode) &&
				 linkedList.tail.equals(secondNode);
		Assert.assertTrue(result);
	}

	@Test
	public void whenPopOperationInLinkedList_ShouldRemoveElementFromFirst() {
		Node<Integer> firstNode = new Node<Integer>(56);
		Node<Integer> secondNode = new Node<Integer>(30);
		Node<Integer> thirdNode = new Node<Integer>(70);
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(firstNode);
		linkedList.append(secondNode);
		linkedList.append(thirdNode);
		linkedList.printNodes();
		int removedElement = linkedList.pop().getKey();
		System.out.println("Removed Element: " + removedElement);
		linkedList.printNodes();
		boolean result = linkedList.head.equals(secondNode) && 
				linkedList.tail.equals(thirdNode);
		Assert.assertTrue(result);
	}

	@Test
	public void whenPopLastOperationInLinkedList_ShouldRemoveElementFromLast() {
		Node<Integer> firstNode = new Node<Integer>(56);
		Node<Integer> secondNode = new Node<Integer>(30);
		Node<Integer> thirdNode = new Node<Integer>(70);
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(firstNode);
		linkedList.append(secondNode);
		linkedList.append(thirdNode);
		linkedList.printNodes();
		int removedElement = linkedList.popLast().getKey();
		System.out.println("Removed Element: " + removedElement);
		linkedList.printNodes();
		boolean result = linkedList.head.equals(firstNode) && 
				linkedList.tail.equals(secondNode);
		Assert.assertTrue(result);
	}

	@Test
	public void whenSearchValue_IsPresentInLinkedList_ShouldReturnTrue() {
		Node<Integer> firstNode = new Node<Integer>(56);
		Node<Integer> secondNode = new Node<Integer>(30);
		Node<Integer> thirdNode = new Node<Integer>(70);
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(firstNode);
		linkedList.append(secondNode);
		linkedList.append(thirdNode);
		linkedList.printNodes();
		INode<Integer> searchNode = linkedList.search(70);
		Assert.assertEquals(thirdNode, searchNode);
	}
	
	@Test
	public void whenSearchValue_IsNotPresentInLinkedList_ShouldReturnFalse() {
		Node<Integer> firstNode = new Node<Integer>(56);
		Node<Integer> secondNode = new Node<Integer>(30);
		Node<Integer> thirdNode = new Node<Integer>(70);
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(firstNode);
		linkedList.append(secondNode);
		linkedList.append(thirdNode);
		linkedList.printNodes();
		INode<Integer> searchNode = linkedList.search(90);
		Assert.assertEquals(null, searchNode);
	}
	
	@Test
	public void givenNumber_WhenInsertedAfterValidNodeInLinkedList_ShouldBeInsertedInBetween() {
		Node<Integer> firstNode = new Node<Integer>(56);
		Node<Integer> secondNode = new Node<Integer>(30);
		Node<Integer> thirdNode = new Node<Integer>(70);
		Node<Integer> insertedNode = new Node<Integer>(40);
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(firstNode);
		linkedList.append(secondNode);
		linkedList.append(thirdNode);
		linkedList.printNodes();
		linkedList.insert(secondNode, insertedNode);
		linkedList.printNodes();
		boolean result = linkedList.head.equals(firstNode) &&
				 linkedList.head.getNext().equals(secondNode) &&
				 linkedList.head.getNext().getNext().equals(insertedNode) &&
				 linkedList.tail.equals(thirdNode);
		Assert.assertTrue(result);
	}
	
	@Test
	public void givenNumber_WhenInsertedAfterInvalidInLinkedList_ShouldNotBeInsertedInBetween() {
		Node<Integer> firstNode = new Node<Integer>(56);
		Node<Integer> secondNode = new Node<Integer>(30);
		Node<Integer> thirdNode = new Node<Integer>(70);
		Node<Integer> insertedNode = new Node<Integer>(40);
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(firstNode);
		linkedList.append(secondNode);
		linkedList.append(thirdNode);
		linkedList.printNodes();
		linkedList.insert(new Node<Integer>(60), insertedNode);
		linkedList.printNodes();
		boolean result = linkedList.head.equals(firstNode) &&
				 linkedList.head.getNext().equals(secondNode) &&
				 linkedList.tail.equals(thirdNode);
		Assert.assertTrue(result);
	}
	
	@Test
	public void givenNumber_WhenDeletedValidNodeInLinkedList_ShouldBeDeleted() {
		Node<Integer> firstNode = new Node<Integer>(56);
		Node<Integer> secondNode = new Node<Integer>(30);
		Node<Integer> thirdNode = new Node<Integer>(40);
		Node<Integer> fourthNode = new Node<Integer>(70);
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(firstNode);
		linkedList.append(secondNode);
		linkedList.append(thirdNode);
		linkedList.append(fourthNode);
		linkedList.printNodes();
		linkedList.delete(thirdNode);
		linkedList.printNodes();
		boolean result = linkedList.head.equals(firstNode) &&
				 linkedList.head.getNext().equals(secondNode) &&
				 linkedList.tail.equals(fourthNode);
		Assert.assertTrue(result);
	}
	
	@Test
	public void givenNumber_WhenDeletedInvalidNodeInLinkedList_ShouldNotBeDeleted() {
		Node<Integer> firstNode = new Node<Integer>(56);
		Node<Integer> secondNode = new Node<Integer>(30);
		Node<Integer> thirdNode = new Node<Integer>(40);
		Node<Integer> fourthNode = new Node<Integer>(70);
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(firstNode);
		linkedList.append(secondNode);
		linkedList.append(thirdNode);
		linkedList.append(fourthNode);
		linkedList.printNodes();
		linkedList.delete(new Node<Integer>(90));
		linkedList.printNodes();
		boolean result = linkedList.head.equals(firstNode) &&
				 linkedList.head.getNext().equals(secondNode) &&
				 linkedList.head.getNext().getNext().equals(thirdNode) &&
				 linkedList.tail.equals(fourthNode);
		Assert.assertTrue(result);
	}
}
