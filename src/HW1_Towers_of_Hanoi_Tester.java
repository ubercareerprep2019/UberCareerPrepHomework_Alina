public class HW1_Towers_of_Hanoi_Tester {
    public static void main (String [] args){
        HW1_Towers_of_Hanoi_temp.Disk first_disk = new HW1_Towers_of_Hanoi_temp.Disk(0, 1);
        HW1_Towers_of_Hanoi_temp.Disk second_disk = new HW1_Towers_of_Hanoi_temp.Disk(0, 2);
        HW1_Towers_of_Hanoi_temp.Disk third_disk = new HW1_Towers_of_Hanoi_temp.Disk(0, 3);

        HW1_Stack<HW1_Towers_of_Hanoi_temp.Disk> stk0 = new HW1_Stack<>();
        stk0.push(first_disk);
        stk0.push(second_disk);
        stk0.push(third_disk);
        HW1_Stack<HW1_Towers_of_Hanoi_temp.Disk> stk1 = new HW1_Stack<>();
        HW1_Stack<HW1_Towers_of_Hanoi_temp.Disk> stk2 = new HW1_Stack<>();
        System.out.println(stk0);

        HW1_Towers_of_Hanoi_temp towers = new HW1_Towers_of_Hanoi_temp(stk0, stk1, stk2);
        towers.moveDisk(0, 1);
        System.out.println(towers.disksAtRod(0));
/**
        HW1_Towers_of_Hanoi.Disk first_disk = new HW1_Towers_of_Hanoi.Disk(0, 1);
        HW1_Towers_of_Hanoi.Disk second_disk = new HW1_Towers_of_Hanoi.Disk(0, 1);
        HW1_Towers_of_Hanoi.Disk third_disk = new HW1_Towers_of_Hanoi.Disk(0, 1);

        HW1_Stack<HW1_Towers_of_Hanoi.Disk> stk0 = new HW1_Stack<>();
        stk0.push(first_disk);
        stk0.push(second_disk);
        stk0.push(third_disk);
        HW1_Stack<HW1_Towers_of_Hanoi.Disk> stk1 = new HW1_Stack<>();
        HW1_Stack<HW1_Towers_of_Hanoi.Disk> stk2 = new HW1_Stack<>();

        HW1_Towers_of_Hanoi.Rod rod0 = new HW1_Towers_of_Hanoi.Rod(0, stk0);
        HW1_Towers_of_Hanoi.Rod rod1 = new HW1_Towers_of_Hanoi.Rod(1, stk1);
        HW1_Towers_of_Hanoi.Rod rod2 = new HW1_Towers_of_Hanoi.Rod(2, stk2);

        HW1_Towers_of_Hanoi towers = new HW1_Towers_of_Hanoi(3, rod0, rod1, rod2);
        towers.moveDisk(rod0.index, rod1.index);*/
    }
}

