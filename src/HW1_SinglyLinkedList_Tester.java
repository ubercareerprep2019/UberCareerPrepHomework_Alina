public class HW1_SinglyLinkedList_Tester {
	void testPushBackAddsOneNode(){
		
	}
	void testPopBackRemovesCorrectNode() {
		
	}
	void testEraseRemovesCorrectNode() {
		
	}
	void testEraseDoesNothingIfNoNode() {
		
	}
	void testElementAtReturnNode() {
		
	}
	void testElementAtReturnsNoNodeIfIndexDoesNotExist() {
		
	}
	void testSizeReturnsCorrectSize() {
		
	}
	public static void main(String [] args) {
		HW1_SinglyLinkedList<Integer> li = new HW1_SinglyLinkedList<Integer>();
		li.pushBack(1);
		li.pushBack(7);
		//System.out.println(li.size());
		//li.pushBack(2);
		
		//System.out.println(li.elementAt(1));
		//System.out.println(li.popBack());
		//System.out.println(li.popBack());
		//System.out.println(li.size());
		
		li.pushBack(3);
		//li.insert(1, 11);
		//li.erase(1);
		
		//System.out.println(li.popBack());
		//System.out.println(li.popBack());
		//System.out.println(li.popBack());
		//System.out.println(li.popBack());
		System.out.println(li);
		
		System.out.println(li.hasCycle());
		
		li.pushBack(7);
		li.pushBack(1);

		System.out.println(li);
		System.out.println(li.hasCycle());
		System.out.println(li.isPalindrome());
	}
}
