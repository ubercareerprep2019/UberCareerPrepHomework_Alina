import org.junit.Assert;

class HW1_Stack_Test extends GroovyTestCase {
    void testPushAndPop() {
        HW1_Stack<Integer> stk = new HW1_Stack<Integer>();
        stk.push(1);
        Assert.assertEquals(1, stk.pop());

        stk.push(3);
        stk.push(4);
        stk.push(1);
        Assert.assertEquals(1, stk.pop());
        Assert.assertEquals(4, stk.pop());
        Assert.assertEquals(3, stk.pop());
    }

    void testTop() {
        HW1_Stack<Integer> stk = new HW1_Stack<Integer>();
        Assert.assertEquals(null, stk.top());

        stk.push(7);
        stk.push(1);
        Assert.assertEquals(1, stk.top());

        stk.pop();
        Assert.assertEquals(7, stk.top());

        stk.pop();
        Assert.assertEquals(null, stk.top());
    }

    void testIsEmpty() {
        HW1_Stack<Integer> stk = new HW1_Stack<Integer>();
        Assert.assertTrue(stk.isEmpty());

        stk.push(7);
        stk.push(1);
        Assert.assertFalse(stk.isEmpty());

        stk.pop();
        stk.pop();
        Assert.assertTrue(stk.isEmpty());
    }

    void testMin() {
        HW1_Stack<Integer> stk = new HW1_Stack<Integer>();
        Assert.assertEquals(null, stk.min());

        stk.push(7);
        stk.push(1);
        stk.push(8);
        Assert.assertEquals(1, stk.min());

        stk.pop();
        stk.pop();
        stk.pop();
        stk.push(0);
        stk.push(2);
        Assert.assertEquals(0, stk.min());

        stk.pop();
        stk.pop();
        System.out.println(stk);
        stk.push(12);
        stk.push(3);
        System.out.println(stk);
        Assert.assertEquals(3, stk.min());
    }

    void testSize() {
        HW1_Stack<Integer> stk = new HW1_Stack<Integer>();
        Assert.assertEquals(0, stk.size());

        stk.push(7);
        stk.push(1);
        stk.push(8);
        Assert.assertEquals(3, stk.size());
    }
}
