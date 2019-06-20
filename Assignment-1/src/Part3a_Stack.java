import java.util.*;
import src.Assignment-1;

/**
 * Implementation of stack using ArrayList.
 * @author alina
 * @param <E> element in stack
 */
public class Part3a_Stack<E extends Comparable<E>> {
	private ArrayList<E> stack;
	private ArrayList<E> sorted_stack;
	private E min = null;
	
	public Part3a_Stack(){
		stack = new ArrayList<E>();
		sorted_stack = new ArrayList<E>();
	}
	public void push(E value) {
		stack.add(value);
		sorted_stack.add(value);
		if (min == null) {
			min = value;
		}
		else if (min.compareTo(value) > 0) {
			min = value;
		}
	}
	
	public E pop(){
		try {
			if(min == stack.get(stack.size() - 1)) {
				sorted_stack.remove((Object)min);
				Object[] temp = sorted_stack.toArray();
				Arrays.sort(temp);
				if(temp.length != 0) {
					min = (E)temp[0];
				}
				else{
					min = null;
				}
			}
			E popped_object = stack.remove(stack.size() - 1);
			for(E object: sorted_stack){
				if(object.equals(popped_object)){
					sorted_stack.remove(object);
					break;
				}
			}
			return popped_object;
		} catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Nothing left in stack.");
			return null;
		}
	}
	
	public E top() {
		try {
			return stack.get(stack.size() - 1);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Nothing left in stack.");
			return null;
		}
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	public E min() {
		return min;
	}
	
	public int size() {
		return stack.size();
	}
	
	public String toString() {
		StringBuffer result = new StringBuffer(stack.size());
		for(E value: stack) {
			result.append(value);
			result.append(" ");
		}
		return result.toString();
	}
}
