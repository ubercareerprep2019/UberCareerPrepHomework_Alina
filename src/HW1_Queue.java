/**
 * Implementation of queue using stacks.
 * @author alina
 * @param <E> element of queue
 */
public class HW1_Queue<E extends Comparable<E>> {
	HW1_Stack<E> stk;
	
	public HW1_Queue(){
		stk = new HW1_Stack<E>();
	}
	
	public void enqueue(E value) {
		HW1_Stack<E> temp = new HW1_Stack<E>();
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
		HW1_Stack<E> temp = new HW1_Stack<E>();
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
