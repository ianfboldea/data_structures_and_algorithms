package examples;

import java.util.HashMap;

public class ContainsCommonItem {
    // 2 parameters - arrays - no size limit
    // return true or false
    // Let's say array1 has a size of n, and array2 has a size of m
    // Runtime: O(n+m)
    // Space complexity: O(n)
    public static boolean containsCommonItem(String[] array1, String[] array2) {
        // Possible Error checking: ensure that array1 and array2 are both not null
        // Can we assume that we will always get two params?
        // Do we need to handle arrays of multiple types?
        // Can we assume a specific data type for the array's values?
        // Add the entirety of the first array's values to a hashmap for O(1) lookup
        HashMap<String, Boolean> lookupMap = new HashMap<>(); // O(n) space required
        for (String item : array1) // O(n)
            if (!lookupMap.getOrDefault(item, false))
                lookupMap.put(item, true);
        // Loop through the second array and search for the existence of each item in our hashmap
        for (String item : array2) // O(m)
            if (lookupMap.getOrDefault(item, false))
                return true;
        return false;
    }
    public static void main(String[] args) {
        String[] arr1 = {"a", "b", "c", "c", "c"};
        String[] arr2 = {"d", "e", "f", "d", "c"};
        System.out.println(ContainsCommonItem.containsCommonItem(arr1, arr2));
    }
}