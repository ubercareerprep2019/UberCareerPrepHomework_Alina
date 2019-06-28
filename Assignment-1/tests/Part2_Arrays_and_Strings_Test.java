import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class Part2_Arrays_and_Strings_Test {
    @Test
    public void testIsStringPermutation() {
        assertTrue(Part2_Arrays_and_Strings.isStringPermutation("Listen", "Silent"));
        assertFalse(Part2_Arrays_and_Strings.isStringPermutation("happiness", "smile"));
        assertFalse(Part2_Arrays_and_Strings.isStringPermutation("", "-1"));
        assertTrue(Part2_Arrays_and_Strings.isStringPermutation("345", "435"));
    }

    @Test
    public void testPairsThatEqualSum() {
        int[] arr = new int[]{1, 7, 3, 18, 1, 2, 2};

        ArrayList<ArrayList<Integer>> target_4 = Part2_Arrays_and_Strings.pairsThatEqualSum(arr, 4);
        ArrayList<ArrayList<Integer>> target_0 = Part2_Arrays_and_Strings.pairsThatEqualSum(arr, 0);

        assert target_0.size() == 0;
        assert target_4.size() == 2;
    }

    @Test
    public void testPairsThatEqualSum_optimized() {
        int[] arr = new int[]{1, 7, 3, 18, 1, 2, 2};
        int[] arr2 = new int[]{2, 4, 3, 1, 5};

        ArrayList<ArrayList<Integer>> target_4 = Part2_Arrays_and_Strings.pairsThatEqualSum_optimized(arr, 4);
        ArrayList<ArrayList<Integer>> target_0 = Part2_Arrays_and_Strings.pairsThatEqualSum_optimized(arr, 0);
        ArrayList<ArrayList<Integer>> target_6 = Part2_Arrays_and_Strings.pairsThatEqualSum_optimized(arr2, 6);
        System.out.println(target_6);
        System.out.println(target_4);
        System.out.println(target_0);

        assert target_0.size() == 0;
        assert target_4.size() == 2;
    }
}
