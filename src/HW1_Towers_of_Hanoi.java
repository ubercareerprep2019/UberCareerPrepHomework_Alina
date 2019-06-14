import org.fest.assertions.ComparableAssert;
import org.jetbrains.annotations.NotNull;

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
/**
public class HW1_Towers_of_Hanoi<T extends Comparable<T>> {
    private Rod rod0;
    private Rod rod1;
    private Rod rod2;
    private int num_of_rods;

    public HW1_Towers_of_Hanoi(int number_of_rods, Rod rod_0, Rod rod_1, Rod rod_2){
        rod0 = rod_0;
        rod1 = rod_1;
        rod2 = rod_2;
        num_of_rods = number_of_rods;
    }

    public static class Disk implements Comparable<HW1_Towers_of_Hanoi.Disk> {
        int rod;
        int size;
        public Disk(int rod_index, int rod_size){
            rod = rod_index;
            size = rod_size;
        }

        public int compareTo(@NotNull Disk o) {
            if(o.size > this.size){
                return 1;
            }
            return 0;
        }
    }

    public static class Rod implements Comparable<HW1_Towers_of_Hanoi.Rod>{
        int index;
        private HW1_Stack<T> rod;
        public Rod(int rod_index, HW1_Stack<T> disks_on_rod){
            index = rod_index;
            rod = disks_on_rod;
        }
        public int compareTo(@NotNull Rod o) {
            if(o.index > this.index){
                return 1;
            }
            return 0;
        }
    }

    //unsigned integer
    void moveDisk(int startingRod, int destinationRod){

    }

    //unsigned integer
    ArrayList<Disk> disksAtRod(int rodIndex){

    }

    //unsigned integer
    int numberOfRods(){
        return num_of_rods;
    }
}
*/