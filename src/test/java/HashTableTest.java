import org.junit.Test;
import org.junit.Assert;

import linkedlist.*;

public class HashTableTest {
	
	@Test
	public void givenSentence_WhenWordsAreAddedToList_ShouldReturnWordFrequency() {
		String sentence = "To be or not to be";
		HashTable<String, Integer> hashTable = new HashTable<>();
		String[] words = sentence.toLowerCase().split(" ");
		for(String word : words) {
			Integer value = hashTable.get(word);
			if(value == null) {
				value = 1;
			}
			else {
				value++;
			}
			hashTable.add(word, value);
		}
		int frequency = hashTable.get("to");
		hashTable.printHashTable();
		Assert.assertEquals(2, frequency);
	}
}
