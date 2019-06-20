import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

class Part2_Arrays_and_Strings_Test {
    @Test
    void testIsStringPermutation() {
        Assert.assertTrue(Part2_Arrays_and_Strings.isStringPermutation("Listen", "Silent"));
        Assert.assertFalse(Part2_Arrays_and_Strings.isStringPermutation("happiness", "smile"));
        Assert.assertFalse(Part2_Arrays_and_Strings.isStringPermutation("", "-1"));
        Assert.assertTrue(Part2_Arrays_and_Strings.isStringPermutation("345", "435"));
    }

    @Test
    void testPairsThatEqualSum() {
        int[] arr = new int[]{1, 7, 3, 18, 1, 2, 2};
        /*
        int[][] correct_result1 =  [[1, 3], [2, 2]];
        int[][] correct_result2 = [[]];
        */

        ArrayList<ArrayList<Integer>> target_4 = Part2_Arrays_and_Strings.pairsThatEqualSum(arr, 4);
        ArrayList<ArrayList<Integer>> target_0 = Part2_Arrays_and_Strings.pairsThatEqualSum(arr, 0);

        assert target_0.size() == 0;
        assert target_4.size() == 2;

        /*
        for(int i = 0; i < correct_result1.length; i++){
            for(int j = 0; j < correct_result1[i].length; j++){
                Assert.assertEquals(correct_result1[i][j], target_4.get(i).get(j));
            }
        }
        for(int i = 0; i < correct_result2.length; i++){
            for(int j = 0; j < correct_result2[i].length; j++){
                Assert.assertEquals(correct_result1[i][j], target_0.get(i).get(j));
            }
        }*/
    }
}
