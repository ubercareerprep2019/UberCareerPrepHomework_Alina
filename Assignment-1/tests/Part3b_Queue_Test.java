import org.junit.Test;
import org.junit.Assert;

public class Part3b_Queue_Test {
    @Test
    public void testQueue() {
        Part3b_Queue<Integer> queue = new Part3b_Queue<Integer>();

        queue.enqueue(7);
        queue.enqueue(1);
        queue.enqueue(3);

        Assert.assertEquals(7, queue.dequeue());
        Assert.assertEquals(1, queue.dequeue());
        Assert.assertEquals(3, queue.dequeue());
    }

}