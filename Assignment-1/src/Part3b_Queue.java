/**
 * Implementation of queue using stacks.
 * @author alina
 * @param <E> element of queue
 */
public class Part3b_Queue<E extends Comparable<E>> {
	Part3a_Stack<E> stk;
	
	public Part3b_Queue(){
		stk = new Part3a_Stack<E>();
	}
	
	public void enqueue(E value) {
		Part3a_Stack<E> temp = new Part3a_Stack<E>();
		while(!stk.isEmpty()) {
			E previous_value = stk.pop();
			temp.push(previous_value);
		}
		stk.push(value);
		while(!temp.isEmpty()) {
			stk.push(temp.pop());
		}
	}
	
	public Comparable<E> dequeue() {
		return stk.pop();
	}
	
	public String toString() {
		StringBuffer result = new StringBuffer(stk.size());
		Part3a_Stack<E> temp = new Part3a_Stack<E>();
		while(!stk.isEmpty()) {
			E value = stk.pop();
			result.append(value);
			result.append(" ");
			temp.push(value);
		}
		while(!temp.isEmpty()) {
			stk.push(temp.pop());
		}
		return result.toString();
	}
}
