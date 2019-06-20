import org.junit.Assert;

import java.util.ArrayList;

public class Part5_Towers_of_Hanoi_Test extends GroovyTestCase {
    public void testMoveDiskAndDisksAtRod() {
        Part5_Towers_of_Hanoi.Disk first_disk = new Part5_Towers_of_Hanoi.Disk(1);
        Part5_Towers_of_Hanoi.Disk second_disk = new Part5_Towers_of_Hanoi.Disk(2);
        Part5_Towers_of_Hanoi.Disk third_disk = new Part5_Towers_of_Hanoi.Disk(3);

        Part3a_Stack<Part5_Towers_of_Hanoi.Disk> stk0 = new Part3a_Stack<Part5_Towers_of_Hanoi.Disk>();
        stk0.push(first_disk);
        stk0.push(second_disk);
        stk0.push(third_disk);
        Part3a_Stack<Part5_Towers_of_Hanoi.Disk> stk1 = new Part3a_Stack<Part5_Towers_of_Hanoi.Disk>();
        Part3a_Stack<Part5_Towers_of_Hanoi.Disk> stk2 = new Part3a_Stack<Part5_Towers_of_Hanoi.Disk>();

        Part5_Towers_of_Hanoi towers = new Part5_Towers_of_Hanoi(stk0, stk1, stk2);
        towers.moveDisk(0, 1);

        ArrayList<Part5_Towers_of_Hanoi.Disk> t0 = towers.disksAtRod((0));
        Assert.assertEquals(second_disk, t0.get(0));
        Assert.assertEquals(first_disk, t0.get(1));

        ArrayList<Part5_Towers_of_Hanoi.Disk> t1 = towers.disksAtRod((1));
        Assert.assertEquals(third_disk, t1.get(0));
    }

}
