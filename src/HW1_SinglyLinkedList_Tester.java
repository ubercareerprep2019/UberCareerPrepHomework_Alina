public class HW1_SinglyLinkedList_Tester {
	private static void testPushBackAddsOneNode(){
		HW1_SinglyLinkedList<Integer> li = new HW1_SinglyLinkedList<>();
		li.pushBack(8);
		System.out.println(li.popBack());
	}
	private static void testPopBackRemovesCorrectNode() {
		HW1_SinglyLinkedList<Integer> li = new HW1_SinglyLinkedList<>();
		li.pushBack(8);
		li.pushBack(10);
		System.out.println(li.popBack());
		System.out.println(li.popBack());
	}
	private static void testEraseRemovesCorrectNode() {
		HW1_SinglyLinkedList<Integer> li = new HW1_SinglyLinkedList<>();
		li.pushBack(8);
		li.pushBack(10);
		li.pushBack(7);
		li.erase(0);
		System.out.println(li);
	}
	private static void testEraseDoesNothingIfNoNode() {
		HW1_SinglyLinkedList<Integer> li = new HW1_SinglyLinkedList<>();
		li.erase(0);
		li.pushBack(8);
		li.pushBack(10);
		li.pushBack(7);
		li.erase(10);
		System.out.println(li);
	}
	private static void testElementAtReturnNode() {
		HW1_SinglyLinkedList<Integer> li = new HW1_SinglyLinkedList<>();
		li.pushBack(8);
		li.pushBack(10);
		li.pushBack(7);
		System.out.println(li.elementAt(0));
		System.out.println(li.elementAt(1));
		System.out.println(li.elementAt(2));
	}
	private static void testElementAtReturnsNoNodeIfIndexDoesNotExist() {
		HW1_SinglyLinkedList<Integer> li = new HW1_SinglyLinkedList<>();
		System.out.println(li.elementAt(0));
		li.pushBack(8);
		li.pushBack(10);
		li.pushBack(7);
		System.out.println(li.elementAt(4));
	}
	private static void testSizeReturnsCorrectSize() {
		HW1_SinglyLinkedList<Integer> li = new HW1_SinglyLinkedList<>();
		System.out.println(li.size());
		li.pushBack(8);
		li.pushBack(10);
		li.pushBack(7);
		System.out.println(li.size());
	}
	public static void main(String [] args) {
		//testPushBackAddsOneNode();
		//testPopBackRemovesCorrectNode();
		//testEraseRemovesCorrectNode();
		//testEraseDoesNothingIfNoNode();
		//testElementAtReturnNode();
		//testElementAtReturnsNoNodeIfIndexDoesNotExist();
		testSizeReturnsCorrectSize();
		/**
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
		System.out.println(li.isPalindrome());*/
	}
}
