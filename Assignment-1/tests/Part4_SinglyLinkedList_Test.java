import org.junit.Test;
import org.junit.Assert;

public class Part4_SinglyLinkedList_Test {
    @Test
    public void testPushBackAndPopBack() {
        Part4_SinglyLinkedList<Integer> li = new Part4_SinglyLinkedList<Integer>();
        li.pushBack(1);
        li.pushBack(7);
        Assert.assertEquals(7, (int)li.popBack());
        Assert.assertEquals(1, (int)li.popBack());
    }

    @Test
    public void testInsertAndElementAt() {
        Part4_SinglyLinkedList<Integer> li = new Part4_SinglyLinkedList<Integer>();
        li.pushBack(1);
        li.pushBack(7);
        li.insert(0, 11);
        Assert.assertEquals(11, (int)li.elementAt(0));

        li.insert(1, 12);
        Assert.assertEquals(12, (int)li.elementAt(1));

        li.insert(3, 13);
        Assert.assertEquals(13, (int)li.elementAt(3));

        li.insert(10, 14);//prints to stdout: Index not in list.
        Assert.assertEquals(null, li.elementAt(10));//prints to stdout: Index not in list.
    }

    @Test
    public void testErase() {
        Part4_SinglyLinkedList<Integer> li = new Part4_SinglyLinkedList<Integer>();
        li.pushBack(1);
        li.pushBack(7);
        li.erase(1);
        Assert.assertEquals(null, li.elementAt(1));//prints to stdout: Index not in list.

        li.erase(2);//prints to stdout: Index not in list.
    }

    @Test
    public void testSize() {
        Part4_SinglyLinkedList<Integer> li = new Part4_SinglyLinkedList<Integer>();
        Assert.assertEquals(0, li.size());

        li.pushBack(1);
        li.pushBack(7);
        Assert.assertEquals(2, li.size());
    }

    @Test
    public void testHasCycle() {
        Part4_SinglyLinkedList<Integer> li = new Part4_SinglyLinkedList<Integer>();

        li.pushBack(1);
        li.pushBack(7);
        li.pushBack(3);
        Assert.assertFalse(li.hasCycle());

        li.pushBack(1);
        Assert.assertTrue(li.hasCycle());
    }

    @Test
    public void testIsPalindrome() {
        Part4_SinglyLinkedList<Integer> li = new Part4_SinglyLinkedList<Integer>();

        li.pushBack(1);
        li.pushBack(7);
        li.pushBack(3);
        Assert.assertFalse(li.isPalindrome());

        li.pushBack(3);
        li.pushBack(7);
        li.pushBack(1);
        Assert.assertTrue(li.isPalindrome());

        li.popBack();
        li.popBack();
        li.popBack();
        li.pushBack(7);
        li.pushBack(1);
        Assert.assertTrue(li.isPalindrome());
    }

    @Test
    public void testPushBackAddsOneNode() {
        Part4_SinglyLinkedList<Integer> li = new Part4_SinglyLinkedList<Integer>();
        li.pushBack(8);
        Assert.assertEquals(8, (int)li.popBack());
    }

    @Test
    public void testPopBackRemovesCorrectNode() {
        Part4_SinglyLinkedList<Integer> li = new Part4_SinglyLinkedList<Integer>();
        li.pushBack(8);
        li.pushBack(10);
        Assert.assertEquals(10, (int)li.popBack());
        Assert.assertEquals(8, (int)li.popBack());
    }

    @Test
    public void testEraseRemovesCorrectNode() {
        Part4_SinglyLinkedList<Integer> li = new Part4_SinglyLinkedList<Integer>();
        li.pushBack(8);
        li.pushBack(10);
        li.pushBack(7);
        li.erase(0);
        Assert.assertEquals(7, (int)li.popBack());
        Assert.assertEquals(10, (int)li.popBack());
    }

    @Test
    public void testEraseDoesNothingIfNoNode() {
        Part4_SinglyLinkedList<Integer> li = new Part4_SinglyLinkedList<Integer>();
        li.erase(0);//prints to stdout: Index not in list.

        li.pushBack(8);
        li.pushBack(10);
        li.pushBack(7);
        li.erase(10);//prints to stdout: Index not in list.

        Assert.assertEquals(7, (int)li.popBack());
        Assert.assertEquals(10, (int)li.popBack());
        Assert.assertEquals(8, (int)li.popBack());
    }

    @Test
    public void testElementAtReturnNode() {
        Part4_SinglyLinkedList<Integer> li = new Part4_SinglyLinkedList<Integer>();
        li.pushBack(8);
        li.pushBack(10);
        li.pushBack(7);
        Assert.assertEquals(8, (int)li.elementAt(0));
        Assert.assertEquals(10, (int)li.elementAt(1));
        Assert.assertEquals(7, (int)li.elementAt(2));
    }

    @Test
    public void testElementAtReturnsNoNodeIfIndexDoesNotExist() {
        Part4_SinglyLinkedList<Integer> li = new Part4_SinglyLinkedList<Integer>();
        Assert.assertEquals(null, li.elementAt(0));//prints to stdout: Index not in list.

        li.pushBack(8);
        li.pushBack(10);
        li.pushBack(7);
        Assert.assertEquals(null, li.elementAt(10));//prints to stdout: Index not in list.

    }

    @Test
    public void testSizeReturnsCorrectSize() {
        Part4_SinglyLinkedList<Integer> li = new Part4_SinglyLinkedList<Integer>();
        Assert.assertEquals(0, li.size());//prints to stdout: Index not in list.

        li.pushBack(8);
        li.pushBack(10);
        li.pushBack(7);
        Assert.assertEquals(3, li.size());
    }

}
