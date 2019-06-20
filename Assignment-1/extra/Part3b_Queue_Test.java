import org.junit.Assert;

public class Part3b_Queue_Test extends GroovyTestCase {
    public void testQueue() {
        HW1_Queue<Integer> queue = new HW1_Queue<Integer>();

        queue.invokeMethod("enqueue", new Object[]{7});
        queue.invokeMethod("enqueue", new Object[]{1});
        queue.invokeMethod("enqueue", new Object[]{3});

        Assert.assertEquals(7, queue.invokeMethod("dequeue", new Object[0]));
        Assert.assertEquals(1, queue.invokeMethod("dequeue", new Object[0]));
        Assert.assertEquals(3, queue.invokeMethod("dequeue", new Object[0]));
    }

}
