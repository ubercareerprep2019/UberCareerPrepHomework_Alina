import java.util.HashSet;

public class HW1_SinglyLinkedList<T extends Comparable<T>> {
	private Node<T> head;
	
	private class Node<T>{
		private T data;
		private Node<T> next;
		
		private Node(T value){
			data = value;
			next = null;
		}
	}
	
	public HW1_SinglyLinkedList() {
		head = new Node<>(null);
	}
	
	/**
	 * Adds a single node containing data to the end of the list.
	 */
	void pushBack(T data) {
		Node<T> node_to_be_added = new Node<>(data);
		Node<T> current = head;
		
		if(head.data == null) {
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
		T last_data;
		
		if(last == null) {
			last_data = head.data;
			head.data = null;
		} else {
			while(last.next != null) {
				second_to_last = second_to_last.next;
				last = second_to_last.next;
			}
			last_data = last.data;
			second_to_last.next = null;
		}
		return last_data;
	}
	
	//unsigned integer index
	/**
	 * Adds a single node containing data to a chosen location in the list. If the 
	 * index is above the size of the list, do nothing.
	 */
	void insert(int index, T data) {
		int count = 0;
		Node<T> current = head;
		Node<T> node_to_be_added = new Node<>(data);
		Node<T> temp;
		try {
			if(head.data != null) {
				int one_before_index = index - 1;
				if(index == 0){
					node_to_be_added.next = current;
					head = node_to_be_added;
				}
				else {
					while (count < one_before_index) {
						current = current.next;
						count++;
					}
					temp = current.next;
					current.next = node_to_be_added;
					node_to_be_added.next = temp;
				}
				
			}
		} catch (Exception e){
			System.out.println("Index not in list.");
		}
	}
	
	//unsigned integer index
	/**
	 * Erases a single node at the index location in the list.
	 */
	void erase(int index) {
		int count = 0;
		Node<T> current = head;
		Node<T> one_after_erased_node;
		try {
			if(head.data != null) {
				if(index == 0){
					head = current.next;
				}
				else if(index >= this.size()){
					System.out.println("Index not in list.");
				}
				else {
					while (count != (index - 1)) {
						current = current.next;
						count++;
					}
					one_after_erased_node = (current.next).next;
					current.next = one_after_erased_node;
				}
			}
			else{
				System.out.println("Index not in list.");
			}
		} catch (Exception e){
			System.out.println("Index not in list.");
		}
	}
	
	//unsigned integer index
	/**
	 * Returns a single node at the index location in the list.
	 */
	T elementAt(int index) {
		int count = 0;
		Node<T> current = head;
		try {
			if(head.data != null) {
				while(count != index) {
					current = current.next;
					count++;
				}
			}
			else if(index >= this.size()){
				System.out.println("Index not in list.");
			}
			else{
				System.out.println("Index not in list.");
				return null;
			}
			return current.data;
		} catch (Exception e){
			System.out.println("Index not in list.");
			return null;
		}
	}
	//unsigned integer 
	/**
	 * Returns the length of the list.
	 */
	int size() {
		int count = 0;
		Node<T> current = head;
		if(head.data != null) {
			while(current.next != null) {
				current = current.next;
				count++;
			}
			count++;
		}
		return count;
	}
	
	/**
	 * Detects cycles in the list. Cycles can happen if a given node references an 
	 * earlier node for the �next� reference. 
	 */
	boolean hasCycle() {
		HashSet<T> node_list = new HashSet<>();
		Node<T> current = head;
		
		if(head.data != null) {
			while(current.next != null) {
				if (node_list.contains(current.data)) {
					return true;
				}
				node_list.add(current.data);
				current = current.next;
			}
			return node_list.contains(current.data);
		}
		return false;
	}
	
	/**
	 * Checks if linked list is a palindrome.
	 */
	boolean isPalindrome() {
	    HW1_Stack<T> stk = new HW1_Stack<T>();
	    int stk_size = this.size();
		int halfway_index = stk_size / 2;
		int parity = stk_size % 2;
		int count = 0;
		Node<T> current = head;

		while(count < halfway_index) {
            stk.push(current.data);
            current = current.next;
            count++;
        }
        if(parity == 1){
		    current = current.next;
        }
        while(current.next != null){
		    if (stk.pop() != current.data) {
                return false;
            }
            current = current.next;
        }
        if (stk.pop() != current.data) {
            return false;
        }
        if(!stk.isEmpty()){
		    return false;
        }
        return true;
	}

    public String toString() {
        StringBuffer result = new StringBuffer(this.size());
        Node<T> current = head;
        while(current.next != null){
            result.append(current.data);
            result.append(" -> ");
            current = current.next;
        }
        result.append(current.data);
        result.append(" -> null");
        return result.toString();
    }
}
