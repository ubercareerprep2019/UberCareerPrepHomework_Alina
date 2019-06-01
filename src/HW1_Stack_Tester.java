/**
 * Stack tester.
 * @author alina
 */
public class HW1_Stack_Tester {
	public static void main(String[] args) {
		HW1_Stack<Integer> test = new HW1_Stack<Integer>();
		test.push(1);
		test.pop();
		System.out.println();
		
		HW1_Stack<Integer> stk = new HW1_Stack<Integer>();
		stk.push(3);
		stk.push(4);
		stk.push(1);
		System.out.println("Initialized stack... " + stk);
		
		System.out.println("Top of stack: " + stk.top());
		System.out.println("Empty? " + stk.isEmpty());
		System.out.println("Size? " + stk.size());
		System.out.println("Min? " + stk.min());
		
		System.out.println("Popped " + stk.pop());
		System.out.println("Stack: " + stk);
		System.out.println("Min? " + stk.min());
		System.out.println("Popped " + stk.pop());
		System.out.println("Stack: " + stk);
		System.out.println("Min? " + stk.min());
		System.out.println("Popped " + stk.pop());
		System.out.println("Stack: " + stk);
		
		System.out.println("Empty? " + stk.isEmpty());
		
		stk.pop();
		stk.top();
	}
}
