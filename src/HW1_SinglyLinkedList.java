public class HW1_SinglyLinkedList<T> {
	private Node<T> head;
	
	private class Node<T>{
		private T data;
		private Node<T> next;
		
		public Node(T value){
			data = value;
			next = null;
		}
	}
	
	public HW1_SinglyLinkedList() {
		head = new Node<T>(null);
	}
	
	/**
	 * Adds a single node containing data to the end of the list.
	 */
	void pushBack(T data) {
		Node<T> node_to_be_added = new Node<T>(data);
		Node<T> current = head;
		
		if(head.next == null) {
			head = node_to_be_added;
		} else {
			while(current.next != null) {
				current = current.next;
			}
			current.next = node_to_be_added;
		}
	}
	
	/**
	 * Removes a single node from the end of the list.
	 */
	T popBack() {
		Node<T> second_to_last = head;
		Node<T> last = head.next;
		T last_data = null;
		
		if(last == null) {
			last_data = head.data;
			head = null;
		} /**else {
			while(last.next != null) {
				second_to_last = second_to_last.next;
				last = second_to_last.next;
			}
			last_data = last.data;
			second_to_last.next = null;
		}*/
		return last_data;
	}
	
	//unsigned integer index
	void insert(int index, T data) {
		
	}
	
	//unsigned integer index
	void erase(int index) {
		
	}
	
	//unsigned integer index
	T elementAt(int index) {
		return null;
		
	}
	//unsigned integer 
	int size() {
		return 0;
	}
}
