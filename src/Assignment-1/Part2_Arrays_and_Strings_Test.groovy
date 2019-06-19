import org.junit.Assert;

class Part2_Test extends GroovyTestCase {
    void testIsStringPermutation() {
        Assert.assertTrue(Part2.isStringPermutation("Listen", "Silent"));
        Assert.assertFalse(Part2.isStringPermutation("happiness", "smile"));
        Assert.assertFalse(Part2.isStringPermutation("", "-1"));
        Assert.assertTrue(Part2.isStringPermutation("345", "435"));
    }
    void testPairsThatEqualSum() {
        int[] arr = [1, 7, 3, 18, 1, 2, 2];
        int[][] correct_result1 =  [[1, 3], [2, 2]];
        int[][] correct_result2 = [[]];

        ArrayList<ArrayList<Integer>> target_4 = Part2.pairsThatEqualSum(arr, 4);
        ArrayList<ArrayList<Integer>> target_0 = Part2.pairsThatEqualSum(arr, 0);
        for(int i = 0; i < correct_result1.length; i++){
            for(int j = 0; j < correct_result1[i].length; j++){
                Assert.assertEquals(correct_result1[i][j], target_4.get(i).get(j));
            }
        }
        for(int i = 0; i < correct_result2.length; i++){
            for(int j = 0; j < correct_result2[i].length; j++){
                Assert.assertEquals(correct_result1[i][j], target_0.get(i).get(j));
            }
        }
    }
}
