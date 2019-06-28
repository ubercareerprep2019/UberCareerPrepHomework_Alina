

import java.util.ArrayList;

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
public class Part5_Towers_of_Hanoi<T extends Comparable<T>> {
    private Part3a_Stack<Disk> rod0;
    private Part3a_Stack<Disk> rod1;
    private Part3a_Stack<Disk> rod2;
    private ArrayList<Part3a_Stack<Disk>> list_of_rods;

    public Part5_Towers_of_Hanoi(Part3a_Stack<Disk> rod_0, Part3a_Stack<Disk> rod_1, Part3a_Stack<Disk> rod_2){
        rod0 = rod_0;
        rod1 = rod_1;
        rod2 = rod_2;
        list_of_rods = new ArrayList<>();
        list_of_rods.add(rod0);
        list_of_rods.add(rod1);
        list_of_rods.add(rod2);
    }

    public static class Disk implements Comparable<Part5_Towers_of_Hanoi.Disk> {
        int size;
        public Disk(int rod_size){
            size = rod_size;
        }

        public int compareTo(Disk o) {
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
        Part3a_Stack starting_stack = list_of_rods.get(startingRod);
        Part3a_Stack destination_stack = list_of_rods.get(destinationRod);
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
        Part3a_Stack temp = list_of_rods.get(rodIndex);
        while(!temp.isEmpty()){
            disks_in_rod.add((Disk)temp.pop());
        }
        return disks_in_rod;
    }
}
