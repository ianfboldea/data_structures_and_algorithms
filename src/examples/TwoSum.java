package examples;

import java.util.HashSet;

// Two inputs, one array (in memory), one integer for the sum
public class TwoSum {
    // Time complexity: O(n^2)
    // Space complexity: O(1)
    public static boolean twoSumNaive(int[] arr, int sum) {
        if (arr == null) return false;
        for (int outerIndex = 0; outerIndex < arr.length-1; outerIndex++) {
            for (int innerIndex = outerIndex + 1; innerIndex < arr.length; innerIndex++) {
                if (arr[innerIndex] + arr[outerIndex] == sum)
                    return true;
            }
        }
        return false;
    }
    // Time complexity: O(n)
    // Space complexity: O(n)
    public static boolean twoSum(int[] arr, int sum) {
        if (arr == null) return false;
        HashSet<Integer> lookupSet = new HashSet<>();
        for (int item : arr) { // O(n)
            if (lookupSet.contains(sum-item)) // O(1)
                return true;
            lookupSet.add(item);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(TwoSum.twoSum(arr, 3));
    }
}
