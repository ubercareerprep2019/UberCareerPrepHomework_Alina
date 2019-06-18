import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Towers of Hanoi is a mathematical puzzle where we have three rods and n disks. The objective
 * of the puzzle is to move the entire stack to another rod, obeying the following simple rules (from
 * geeksforgeeks.com):
 * 1. Only one disk can be moved at a time.
 * 2. Each move consists of taking the upper disk from one of the stacks and placing it on top
 * of another stack i.e. a disk can only be moved if it is the uppermost disk on a stack.
 * 3. No disk may be placed on top of a smaller disk.
 * Create a class to implement the Towers of Hanoi puzzle logic. You will need at least the
 * following methods.
 */
public class HW1_Towers_of_Hanoi<T extends Comparable<T>> {
    private HW1_Stack<Disk> rod0;
    private HW1_Stack<Disk> rod1;
    private HW1_Stack<Disk> rod2;
    private HashMap<Integer, HW1_Stack> hmap;

    public HW1_Towers_of_Hanoi(HW1_Stack<Disk> rod_0, HW1_Stack<Disk> rod_1, HW1_Stack<Disk> rod_2){
        rod0 = rod_0;
        rod1 = rod_1;
        rod2 = rod_2;
        hmap = new HashMap<>();
        hmap.put(0, rod0);
        hmap.put(1, rod1);
        hmap.put(2, rod2);
    }

    public static class Disk implements Comparable<HW1_Towers_of_Hanoi.Disk> {
        int size;
        public Disk(int rod_size){
            size = rod_size;
        }

        public int compareTo(@NotNull Disk o) {
            if(o.size > this.size){
                return 1;
            }
            return 0;
        }

        public String toString() {
            StringBuffer result = new StringBuffer(100);
            result.append(size);
            return result.toString();
        }
    }

    //unsigned integer
    void moveDisk(int startingRod, int destinationRod){
        Comparable destination_top_disk = null;
        HW1_Stack starting_stack = hmap.get(startingRod);
        HW1_Stack destination_stack = hmap.get(destinationRod);
        Comparable starting_top_disk = starting_stack.pop();
        if(!destination_stack.isEmpty()){
            destination_top_disk = destination_stack.top();
        }

        if(destination_top_disk != null && starting_top_disk.compareTo(destination_top_disk) > 0){
            starting_stack.push(starting_top_disk);
            System.out.println("Error: trying to place bigger disk on smaller disk.");
        }
        else{
            destination_stack.push(starting_top_disk);
        }
    }

    //unsigned integer
    ArrayList<Disk> disksAtRod(int rodIndex){
        ArrayList<Disk> disks_in_rod = new ArrayList<>();
        HW1_Stack temp = hmap.get(rodIndex);
        while(!temp.isEmpty()){
            disks_in_rod.add((Disk)temp.pop());
        }
        return disks_in_rod;
    }
}
