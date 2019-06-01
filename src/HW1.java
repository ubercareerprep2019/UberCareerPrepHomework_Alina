import java.util.*;

public class HW1 {
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
	 */
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
	
	//Testing.
	public static void main(String[] args) {
		//Testing Part 2: isStringPermutation
		System.out.println("Testing Part 2: isStringPermutation...");
		System.out.println(isStringPermutation("Listen", "Silent"));
		System.out.println(isStringPermutation("happiness", "smile"));
		System.out.println(isStringPermutation("", "-1"));
		System.out.println(isStringPermutation("345", "435"));
		System.out.println("\n");
		
		//Testing Part 2: pairsThatEqualSum
		System.out.println("Testing Part 2: pairsthatEqualSum...");
		int[] arr1 = {1, 7, 3, 18, 1, 2, 2};
		ArrayList<ArrayList<Integer>> result = pairsThatEqualSum(arr1, 4);
		System.out.println(Arrays.toString(result.toArray()));
		
		ArrayList<ArrayList<Integer>> result2 = pairsThatEqualSum(arr1, 0);
		System.out.println(Arrays.toString(result2.toArray()));
		System.out.println("\n");
	}
}