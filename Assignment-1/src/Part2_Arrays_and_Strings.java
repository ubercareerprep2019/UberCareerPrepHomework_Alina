import java.util.*;

public class Part2_Arrays_and_Strings {
	//Part 2
	/**
	 * This function takes two strings and returns true if one string is a permutation of 
	 * the other, false otherwise.
	 */
	public static boolean isStringPermutation(String s1, String s2) {
		char[] s1_sorted = s1.toLowerCase().toCharArray();
		char[] s2_sorted = s2.toLowerCase().toCharArray();
		Arrays.sort(s1_sorted);
		Arrays.sort(s2_sorted);
		return Arrays.equals(s1_sorted, s2_sorted);
	}
	
	/**
	 * This function takes an array of integers and a target integer to which the array
	 * elements must sum. It returns an array of all pairs of integers from the input
	 * array whose sum equals the target.
	 *
	 * Order does not matter: [2,4], is the same as [4,2]
	 * No repeats: [2,2,4] -> result: [2,4]
	 */
	public static ArrayList<ArrayList<Integer>> pairsThatEqualSum_optimized(int[] inputArray, int targetSum){
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		HashMap<Integer, Integer> number_to_count = new HashMap<>();

		for(int number: inputArray){
			if(number_to_count.get(number) == null){
				number_to_count.put(number, 1);
			}
			else{
				number_to_count.put(number, number_to_count.get(number) + 1);
			}
		}

		for(Map.Entry<Integer, Integer> entry: number_to_count.entrySet()){
			Integer key = entry.getKey();
			Integer count = entry.getValue();

			Integer opposite = targetSum - key;
			if(key.equals(opposite)){
				Integer num_of_iterations = count/2;
				for(int i = 0; i < num_of_iterations; i++){
					ArrayList<Integer> pair = new ArrayList<>();
					pair.add(key);
					pair.add(opposite);
					result.add(pair);
				}
			}
			else {
				while (count > 0) {
					Integer opposite_count = number_to_count.get(opposite);
					if (opposite_count != null && opposite_count > 0) {
						ArrayList<Integer> pair = new ArrayList<>();
						pair.add(key);
						pair.add(opposite);
						result.add(pair);
						number_to_count.put(opposite, opposite_count - 1);
						number_to_count.put(key, count - 1);
					}
					count--;
				}
			}
		}
		return result;
	}

	public static ArrayList<ArrayList<Integer>> pairsThatEqualSum(int[] inputArray, int targetSum){
		ArrayList<Integer> array_to_check= new ArrayList<Integer>();
		for(int i: inputArray) {
			array_to_check.add(i);
		}
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i < array_to_check.size(); i++) {
			Integer num1 = new Integer(array_to_check.get(i));
			for(int j = i + 1; j < array_to_check.size(); j++){
				Integer num2 = new Integer(array_to_check.get(j));
				if (num1 + num2 == targetSum) {
					List<Integer> pair = Arrays.asList(num1, num2);
					ArrayList<Integer> pair_al = new ArrayList<Integer>(pair);
					array_to_check.removeAll(pair_al);
					result.add(pair_al);
				}
			}
		}
		return result;
	}
}