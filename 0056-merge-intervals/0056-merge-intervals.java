
import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // Step 1: Sort intervals based on starting value
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Step 2: Create a list to store merged intervals
        List<int[]> result = new ArrayList<>();

        // Step 3: Traverse all intervals
        for (int[] interval : intervals) {

            // If list is empty OR no overlap
            if (result.isEmpty() ||
                result.get(result.size() - 1)[1] < interval[0]) {

                result.add(interval);
            }
            else {
                // Merge overlapping intervals
                result.get(result.size() - 1)[1] =
                    Math.max(result.get(result.size() - 1)[1], interval[1]);
            }
        }

        // Step 4: Convert list into 2D array
        return result.toArray(new int[result.size()][]);
    }
}
