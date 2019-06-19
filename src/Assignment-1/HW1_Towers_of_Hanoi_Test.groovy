import org.junit.Assert

class HW1_Towers_of_Hanoi_Test extends GroovyTestCase {
    void testMoveDiskAndDisksAtRod() {
        HW1_Towers_of_Hanoi.Disk first_disk = new HW1_Towers_of_Hanoi.Disk(1);
        HW1_Towers_of_Hanoi.Disk second_disk = new HW1_Towers_of_Hanoi.Disk(2);
        HW1_Towers_of_Hanoi.Disk third_disk = new HW1_Towers_of_Hanoi.Disk(3);

        HW1_Stack<HW1_Towers_of_Hanoi.Disk> stk0 = new HW1_Stack<>();
        stk0.push(first_disk);
        stk0.push(second_disk);
        stk0.push(third_disk);
        HW1_Stack<HW1_Towers_of_Hanoi.Disk> stk1 = new HW1_Stack<>();
        HW1_Stack<HW1_Towers_of_Hanoi.Disk> stk2 = new HW1_Stack<>();

        HW1_Towers_of_Hanoi towers = new HW1_Towers_of_Hanoi(stk0, stk1, stk2);
        towers.moveDisk(0, 1);

        ArrayList<HW1_Towers_of_Hanoi.Disk> t0 = towers.disksAtRod((0));
        Assert.assertEquals(second_disk, t0.get(0));
        Assert.assertEquals(first_disk, t0.get(1));

        ArrayList<HW1_Towers_of_Hanoi.Disk> t1 = towers.disksAtRod((1));
        Assert.assertEquals(third_disk, t1.get(0));
    }
}
