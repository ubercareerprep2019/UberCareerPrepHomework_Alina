/**
 * Queue tester.
 * @author alina
 */
public class HW1_Queue_Tester {
	public static void main(String[] args) {
		HW1_Queue<Integer> queue = new HW1_Queue<Integer>();
		
		queue.enqueue(7);
		queue.enqueue(1);
		queue.enqueue(3);
		System.out.println("Queue: " + queue);

		System.out.println("Dequeued " + queue.dequeue());
		System.out.println("Dequeued " + queue.dequeue());
		System.out.println("Dequeued " + queue.dequeue());
	}
}
