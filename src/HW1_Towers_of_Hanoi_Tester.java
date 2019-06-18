public class HW1_Towers_of_Hanoi_Tester {
    public static void main (String [] args){
        HW1_Towers_of_Hanoi.Disk first_disk = new HW1_Towers_of_Hanoi.Disk(1);
        HW1_Towers_of_Hanoi.Disk second_disk = new HW1_Towers_of_Hanoi.Disk(2);
        HW1_Towers_of_Hanoi.Disk third_disk = new HW1_Towers_of_Hanoi.Disk(3);

        HW1_Stack<HW1_Towers_of_Hanoi.Disk> stk0 = new HW1_Stack<>();
        stk0.push(first_disk);
        stk0.push(second_disk);
        stk0.push(third_disk);
        HW1_Stack<HW1_Towers_of_Hanoi.Disk> stk1 = new HW1_Stack<>();
        HW1_Stack<HW1_Towers_of_Hanoi.Disk> stk2 = new HW1_Stack<>();
        System.out.println(stk0);

        HW1_Towers_of_Hanoi towers = new HW1_Towers_of_Hanoi(stk0, stk1, stk2);
        towers.moveDisk(0, 1);
        System.out.println(towers.disksAtRod(0));
    }
}

