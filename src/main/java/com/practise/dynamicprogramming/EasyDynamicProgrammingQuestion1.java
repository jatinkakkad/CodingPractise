package com.practise.dynamicprogramming;

import java.util.Arrays;

/**
 * Following are the easy Dynamic Programming questions (http://www.geeksforgeeks.org/easy/dynamic-programming/):
 * 1. http://www.geeksforgeeks.org/maximum-sum-path-matrix-top-bottom/
 * 2. http://www.geeksforgeeks.org/longest-increasing-path-matrix/
 * 3. http://www.geeksforgeeks.org/maximum-sum-bitonic-subarray/
 * 4. http://www.geeksforgeeks.org/maximum-length-subsequence-difference-adjacent-elements-either-0-1/
 * 5. http://www.geeksforgeeks.org/unique-paths-in-a-grid-with-obstacles/
 * 6. http://www.geeksforgeeks.org/coin-game-winner-every-player-three-choices/
 * 7. http://www.geeksforgeeks.org/maximum-games-played-winner/
 * 8. http://www.geeksforgeeks.org/convert-strictly-increasing-array-minimum-changes/
 * 9. http://www.geeksforgeeks.org/smallest-sum-contiguous-subarray/
 * 10. http://www.geeksforgeeks.org/find-maximum-possible-stolen-value-houses/
 * 11. http://www.geeksforgeeks.org/find-longest-increasing-subsequence-circular-manner/
 * 12. http://www.geeksforgeeks.org/minimum-insertions-sort-array/
 * 13. http://www.geeksforgeeks.org/minimum-number-deletions-make-sorted-sequence/
 * 14. http://www.geeksforgeeks.org/largest-sum-zig-zag-sequence-in-a-matrix/
 * 15. http://www.geeksforgeeks.org/tabulation-vs-memoizatation/
 * 16. http://www.geeksforgeeks.org/maximum-path-sum-starting-cell-0-th-row-ending-cell-n-1-th-row/
 * 17. http://www.geeksforgeeks.org/maximum-path-sum-triangle/
 * 18. http://www.geeksforgeeks.org/maximum-sum-bi-tonic-sub-sequence/
 * 19. http://www.geeksforgeeks.org/lcs-longest-common-subsequence-three-strings/
 * 20. http://www.geeksforgeeks.org/maximum-decimal-value-path-in-a-binary-matrix/
 * 21. http://www.geeksforgeeks.org/maximum-subsequence-sum-such-that-no-three-are-consecutive/
 * 22. http://www.geeksforgeeks.org/maximum-sum-pairs-specific-difference/
 * 23. http://www.geeksforgeeks.org/game-theory-choice-area/
 * 24. http://www.geeksforgeeks.org/find-maximum-length-snake-sequence/
 * 25. http://www.geeksforgeeks.org/dynamic-programming-high-effort-vs-low-effort-tasks-problem/
 * 26. http://www.geeksforgeeks.org/permutation-coefficient/
 * 27. http://www.geeksforgeeks.org/compute-ncr-p-set-1-introduction-and-dynamic-programming-solution/
 * 28. http://www.geeksforgeeks.org/count-number-binary-strings-without-consecutive-1s/
 * 29. http://www.geeksforgeeks.org/program-nth-catalan-number/
 * 30. http://www.geeksforgeeks.org/dynamic-programming-set-34-assembly-line-scheduling/
 * 31. http://www.geeksforgeeks.org/longest-common-substring/
 * 32. http://www.geeksforgeeks.org/dynamic-programming-set-14-maximum-sum-increasing-subsequence/
 * 33. http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 * 34. http://www.geeksforgeeks.org/longest-common-subsequence/
 */
public class EasyDynamicProgrammingQuestion1 {

    /**
     * 1. http://www.geeksforgeeks.org/maximum-sum-path-matrix-top-bottom/
     *
     * Consider a n*n matrix. Suppose each cell in the matrix has a value assigned.
     * We can go from each cell in row i to a diagonally higher cell in row i+1
     * only [i.e from cell(i, j) to cell(i+1, j-1) and cell(i+1, j+1) only].
     * Find the path from the top row to the bottom row following the
     * aforementioned condition such that the maximum sum is obtained.
     *
     * @param arr
     * @return
     */
    public int maxSumOfCrossPathIn2DArray(int[][] arr) {
        if (arr == null || arr[0].length == 1) {
            return Integer.MIN_VALUE;
        }
        int max = Integer.MIN_VALUE;
        for (int i  = 0; i < arr[0].length; i++) {
            int sum = maxSumOfCrossPathIn2DArrayHelper(arr, 0, i, 0);
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    /**
     * Recursive method to get the max sume for given cell(0,j)
     *
     * @param arr
     * @param i
     * @param j
     * @param sum
     * @return
     */
    int maxSumOfCrossPathIn2DArrayHelper(int[][] arr, int i, int j, int sum) {
        if(i == arr.length - 1) {
            return arr[i][j];
        }
        int sum1 = Integer.MIN_VALUE;
        int sum2 = Integer.MIN_VALUE;
        if ((j-1) >= 0) {
            sum1 = sum + arr[i][j] + maxSumOfCrossPathIn2DArrayHelper(arr, i+1, j-1, sum);
        }
        if ((j+1) < arr[0].length) {
            sum2 = sum + arr[i][j] + maxSumOfCrossPathIn2DArrayHelper(arr, i+1, j+1, sum);
        }
        return sum1>sum2 ? sum1 : sum2;
    }

    /**
     * 2. http://www.geeksforgeeks.org/longest-increasing-path-matrix/
     *
     * Given a matrix of N rows and M columns. From m[i][j], we can move to m[i+1][j],
     * if m[i+1][j] > m[i][j], or can move to m[i][j+1] if m[i][j+1] > m[i][j]. T
     * he task is print longest path length if we start from (0, 0).
     *
     * @param arr
     * @return
     */
    int longestIncreasingPathInMatrix(int[][] arr) {
        return longestIncreasingPathInMatrix(arr, 0, 0);
    }

    int longestIncreasingPathInMatrix(int[][] arr, int i, int j) {
        if (i == (arr.length - 1) && j == (arr[0].length -1)) {
            return 1;
        }

        int curr = arr[i][j];
        int countI = 0;
        if (i+1 < arr.length && curr < arr[i+1][j]) {
            countI = 1 + longestIncreasingPathInMatrix(arr, i+1, j);
        }

        int countJ = 0;
        if (j+1 < arr[0].length && curr < arr[i][j+1]) {
            countJ = 1 + longestIncreasingPathInMatrix(arr, i, j + 1);
        }

        return (countI > countJ) ? countI : countJ;

    }

    /**
     * 3. http://www.geeksforgeeks.org/maximum-sum-bitonic-subarray/
     *
     * Given an array containing n numbers. The problem is to find the maximum sum bitonic subarray.
     * A bi-tonic sub-array is a sub-array in which elements are first increasing and then decreasing.
     * A strictly increasing or strictly decreasing sub-array is also considered as bitonic subarray.
     * Time Complexity of O(n) is required.
     *
     * @param arr - int array
     * @return max sum of bi-tonic sub-array
     */
    int getMaximumSumSubAtomicSubArray(int[] arr) {
        int len = arr.length;

        int[] msis = new int[arr.length];
        int[] msds = new int[arr.length];

        msis[0] = arr[0];
        for (int i =1; i < len; i++) {
            if (arr[i] > arr[i-1]) {
                msis[i] = msis[i-1] + arr[i];
            } else {
                msis[i] = arr[i];
            }
        }

        msds[len-1] = arr[len-1];
        for (int i =len-2; i >= 0; i--) {
            if (arr[i] > arr[i+1]) {
                msds[i] = msds[i+1] + arr[i];
            } else {
                msds[i] = arr[i];
            }
        }

        int maxSum = 0;
        for (int i = 0; i < len; i++) {
            int sum = msds[i] + msis[i] - arr[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

    /**
     * 4. http://www.geeksforgeeks.org/maximum-length-subsequence-difference-adjacent-elements-either-0-1/
     *
     * Given an array of n integers. The problem is to find maximum length of the sub-sequence
     * with difference between adjacent elements as either 0 or 1.
     *
     * @param arr - array
     * @return - maximum sub-array len
     */
    int maxLenSub(int[] arr) {
        int[] mls = new int[arr.length];
        int max = 0;
        for (int i =1; i < arr.length -1; i++) {
            for (int j=0; j < i; j++) {
                if (Math.abs(arr[i] - arr[j]) <= 1 && mls[i] < (mls[j] + 1)) {
                    mls[i] = mls[j] + 1;
                }
            }
        }

        for (int ml : mls) {
            if (max < ml) max = ml;
        }
        return max+1;
    }

    /**
     *
     * @param arr
     * @return
     */
    int maxPathCount(int[][] arr, int i, int j) {
        if (arr[i][j] == 1) {
            return 0;
        }
        if (i == (arr.length-1) && j == (arr[0].length-1)) {
            return 1;
        }
        int countI = 0;
        int countJ = 0;
        if (i+1 <= (arr.length-1)) {
            countI = maxPathCount(arr, i+1, j);
        }
        if (j+1 <= (arr[0].length -1 )) {
            countJ = maxPathCount(arr, i, j+1);
        }
        return countI + countJ;
    }

    boolean canAWinCoinGame(int n, int x, int y) {
        boolean[] dp = new boolean[n + 1];

        Arrays.fill(dp, false);

        dp[0] = false;
        dp[1] = true;

        // Computing other values.
        for (int i = 2; i <= n; i++) {

            if (i - 1 >= 0 && !dp[i - 1])
                dp[i] = true;
            else if (i - x >= 0 && !dp[i - x])
                dp[i] = true;
            else if (i - y >= 0 && !dp[i - y])
                dp[i] = true;
            else
                dp[i] = false;
        }
        return dp[n];
    }
}
