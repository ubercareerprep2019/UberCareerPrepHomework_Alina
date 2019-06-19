import org.junit.Assert;

class HW1_Queue_Test extends GroovyTestCase {
    void testQueue() {
        HW1_Queue<Integer> queue = new HW1_Queue<Integer>();

        queue.enqueue(7);
        queue.enqueue(1);
        queue.enqueue(3);

        Assert.assertEquals(7, queue.dequeue());
        Assert.assertEquals(1, queue.dequeue());
        Assert.assertEquals(3, queue.dequeue());
    }
}
