import org.junit.Assert

class HW1_SinglyLinkedList_Test extends GroovyTestCase {
    void testPushBackAndPopBack() {
        HW1_SinglyLinkedList<Integer> li = new HW1_SinglyLinkedList<Integer>();
        li.pushBack(1);
        li.pushBack(7);
        Assert.assertEquals(7, li.popBack());
        Assert.assertEquals(1, li.popBack())
    }

    void testInsertAndElementAt() {
        HW1_SinglyLinkedList<Integer> li = new HW1_SinglyLinkedList<Integer>();
        li.pushBack(1);
        li.pushBack(7);
        li.insert(0, 11);
        Assert.assertEquals(11, li.elementAt(0));

        li.insert(1, 12);
        Assert.assertEquals(12, li.elementAt(1));

        li.insert(3, 13);
        Assert.assertEquals(13, li.elementAt(3));

        li.insert(10, 14); //prints to stdout: Index not in list.
        Assert.assertEquals(null, li.elementAt(10)); //prints to stdout: Index not in list.
    }

    void testErase() {
        HW1_SinglyLinkedList<Integer> li = new HW1_SinglyLinkedList<Integer>();
        li.pushBack(1);
        li.pushBack(7);
        li.erase(1);
        Assert.assertEquals(null, li.elementAt(1)); //prints to stdout: Index not in list.

        li.erase(2); //prints to stdout: Index not in list.
    }

    void testSize() {
        HW1_SinglyLinkedList<Integer> li = new HW1_SinglyLinkedList<Integer>();
        Assert.assertEquals(0, li.size());

        li.pushBack(1);
        li.pushBack(7);
        Assert.assertEquals(2, li.size());
    }

    void testHasCycle() {
        HW1_SinglyLinkedList<Integer> li = new HW1_SinglyLinkedList<Integer>();

        li.pushBack(1);
        li.pushBack(7);
        li.pushBack(3);
        Assert.assertFalse(li.hasCycle());

        li.pushBack(1);
        Assert.assertTrue(li.hasCycle());
    }

    void testIsPalindrome() {
        HW1_SinglyLinkedList<Integer> li = new HW1_SinglyLinkedList<Integer>();

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

    //Specific test cases.
    void testPushBackAddsOneNode(){
        HW1_SinglyLinkedList<Integer> li = new HW1_SinglyLinkedList<>();
        li.pushBack(8);
        Assert.assertEquals(8, li.popBack());
    }
    void testPopBackRemovesCorrectNode() {
        HW1_SinglyLinkedList<Integer> li = new HW1_SinglyLinkedList<>();
        li.pushBack(8);
        li.pushBack(10);
        Assert.assertEquals(10, li.popBack());
        Assert.assertEquals(8, li.popBack());
    }
    void testEraseRemovesCorrectNode() {
        HW1_SinglyLinkedList<Integer> li = new HW1_SinglyLinkedList<>();
        li.pushBack(8);
        li.pushBack(10);
        li.pushBack(7);
        li.erase(0);
        Assert.assertEquals(7, li.popBack());
        Assert.assertEquals(10, li.popBack());
    }
    void testEraseDoesNothingIfNoNode() {
        HW1_SinglyLinkedList<Integer> li = new HW1_SinglyLinkedList<>();
        li.erase(0); //prints to stdout: Index not in list.

        li.pushBack(8);
        li.pushBack(10);
        li.pushBack(7);
        li.erase(10); //prints to stdout: Index not in list.

        Assert.assertEquals(7, li.popBack());
        Assert.assertEquals(10, li.popBack());
        Assert.assertEquals(8, li.popBack());
    }
    void testElementAtReturnNode() {
        HW1_SinglyLinkedList<Integer> li = new HW1_SinglyLinkedList<>();
        li.pushBack(8);
        li.pushBack(10);
        li.pushBack(7);
        Assert.assertEquals(8, li.elementAt(0));
        Assert.assertEquals(10, li.elementAt(1));
        Assert.assertEquals(7, li.elementAt(2));
    }
    void testElementAtReturnsNoNodeIfIndexDoesNotExist() {
        HW1_SinglyLinkedList<Integer> li = new HW1_SinglyLinkedList<>();
        Assert.assertEquals(null, li.elementAt(0)); //prints to stdout: Index not in list.

        li.pushBack(8);
        li.pushBack(10);
        li.pushBack(7);
        Assert.assertEquals(null, li.elementAt(10)); //prints to stdout: Index not in list.

    }
    void testSizeReturnsCorrectSize() {
        HW1_SinglyLinkedList<Integer> li = new HW1_SinglyLinkedList<>();
        Assert.assertEquals(0, li.size()); //prints to stdout: Index not in list.

        li.pushBack(8);
        li.pushBack(10);
        li.pushBack(7);
        Assert.assertEquals(3, li.size());
    }
}
