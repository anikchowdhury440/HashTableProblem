package linkedlist;

import org.junit.Assert;
import org.junit.Test;

public class OrderedLinkedListTest {
	@Test
	public void givenThreeNumbers_WhenAddedToLinkedList_ShouldBeAddedToTop() {
		OrderedNode<Integer> firstNode = new OrderedNode<Integer>(56);
		OrderedNode<Integer> secondNode = new OrderedNode<Integer>(30);
		OrderedNode<Integer> thirdNode = new OrderedNode<Integer>(40);
		OrderedNode<Integer> fourthNode = new OrderedNode<Integer>(70);
		OrderedLinkedList<Integer> orderedLinkedList = new OrderedLinkedList<Integer>();
		orderedLinkedList.add(firstNode);
		orderedLinkedList.add(secondNode);
		orderedLinkedList.add(thirdNode);
		orderedLinkedList.add(fourthNode);
		orderedLinkedList.printNodes();
		boolean result = orderedLinkedList.head.equals(secondNode) &&
						 orderedLinkedList.head.getNext().equals(thirdNode) &&
						 orderedLinkedList.head.getNext().getNext().equals(firstNode) &&
						 orderedLinkedList.tail.equals(fourthNode);
		Assert.assertTrue(result);
	}
}
