package com.practise.arrays;

import org.apache.commons.collections4.list.TreeList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Following are the questions to be solved (http://www.geeksforgeeks.org/easy/c-arrays):
 * 1. http://www.geeksforgeeks.org/count-pairs-array-whose-sum-divisible-4/
 * 2. http://www.geeksforgeeks.org/maximum-size-subset-given-sum/
 * 3. http://www.geeksforgeeks.org/two-pointers-technique/
 * 4. http://www.geeksforgeeks.org/find-smallest-subarray-contains-elements-order/
 * 5. http://www.geeksforgeeks.org/generate-original-array-array-store-counts-greater-elements-right/
 * 6. http://www.geeksforgeeks.org/maximizing-array-sum-with-given-operation/
 * 7. http://www.geeksforgeeks.org/print-maximum-shortest-distance/
 * 8. http://www.geeksforgeeks.org/longest-sequence-positive-integers-array/
 * 9. http://www.geeksforgeeks.org/make-three-non-empty-sets-negative-positive-0-products/
 * 10. http://www.geeksforgeeks.org/dividing-array-two-halves-sum/
 * 11. http://www.geeksforgeeks.org/minimum-replacements-make-elements-ternary-array/
 * 12. http://www.geeksforgeeks.org/subsequences-size-three-array-whose-sum-divisible-m/
 * 13. http://www.geeksforgeeks.org/largest-increasing-subsequence-of-consecutive-integers/
 * 14. http://www.geeksforgeeks.org/longest-subsequence-difference-adjacents-one-set-2/
 * 15. http://www.geeksforgeeks.org/largest-derangement-sequence/
 * 16. http://www.geeksforgeeks.org/minimum-product-k-integers-array-positive-integers/
 * 17. http://www.geeksforgeeks.org/distance-closest-zero-every-element/
 * 18. http://www.geeksforgeeks.org/rearrange-array-even-index-elements-smaller-odd-index-elements-greater/
 * 19. http://www.geeksforgeeks.org/minimum-element-whose-n-th-power-greater-product-array-size-n/
 * 20. http://www.geeksforgeeks.org/minimum-number-increment-operations-make-array-elements-equal/
 * 21. http://www.geeksforgeeks.org/find-unique-element-element-occurs-k-times-except-one/
 * 22. http://www.geeksforgeeks.org/count-divisors-array-multiplication/
 * 23. http://www.geeksforgeeks.org/remove-array-end-element-maximize-sum-product/
 * 24. http://www.geeksforgeeks.org/minimum-absolute-difference-xor-values-two-subarrays/
 */
public class EasyArrayQuestions1 {

    /**
     * 1. http://www.geeksforgeeks.org/count-pairs-array-whose-sum-divisible-4/
     *
     * Given a array if ‘n’ positive integers.
     * Count number of pairs of integers in the array that have the sum divisible by 4.
     * @param a - array of positive integer
     * @return number of pairs that are divisible by 4
     */
    int pairsDivisibleBy4(int[] a) {
        int[] modulo = new int[4];
        int count = 0;
        for (int anA : a) {
            int mod = anA % 4;
            modulo[mod]++;
        }
        count += (modulo[0] * (modulo[0] - 1))/2;
        count += (modulo[2] * (modulo[2] - 1))/2;
        count += (modulo[1] * modulo[3]);
        return count;
    }

    /**
     * 2. http://www.geeksforgeeks.org/maximum-size-subset-given-sum/
     *
     * This is an extended version of subset sum problem.
     * Here we need to find size of maximum size subset
     * whose sum is equal to given sum.
     */
    int getMaximumSizeSubsetForGivenSum(int[] a, int sum) {
        if (a == null || a.length == 0) {
            return 0;
        }
        List<Integer> countList = new ArrayList<>();
        //boolean isSubsetSum = isSubsetSum(a, a.length, sum, subset);
        boolean isSubsetSum = countSubSetSum(a, a.length, sum, countList, 0);
        System.out.println("IsSubsetSum : " + isSubsetSum);
        if (isSubsetSum) {
            int max = 0;
            for (int count : countList) {
                System.out.println("One of the counts is: " + count);
                if (count > max) {
                    max = count;
                }
            }
            return max;
        }
        return 0;
    }

    /**
     * Method contains a reference to a list where there is size of all the set where sum of subset is sum.
     * @param set
     * @param n
     * @param sum
     * @param countList
     * @param count
     * @return
     */
    boolean countSubSetSum(int[] set, int n, int sum, List<Integer> countList, int count) {
        if(sum == 0) {
            countList.add(count);
            return true;
        }
        if (n == 0)
            return false;
        // If set[n-1] is greater than sum, not to include it
        if (set[n-1] > sum)
            return  countSubSetSum(set, n-1, sum, countList, count);
        boolean included = countSubSetSum(set, n-1, sum-set[n-1], countList, count+1);
        boolean notIncluded = countSubSetSum(set, n-1, sum, countList, count);
        return included || notIncluded;
    }

    /**
     * 3. http://www.geeksforgeeks.org/two-pointers-technique/
     * Given a sorted array A (sorted in ascending order), having N integers,
     * find if there exists any pair of elements (A[i], A[j]) such that their sum is equal to X.
     *
     * @param a - sorted array
     * @param sum - sum to find
     * @return true if a pair is found with sum 'sum'
     */
    public boolean isSumEqualX(int[] a, int sum) {
        if (a.length < 2) {
            return false;
        }
        int first = 0;
        int last = a.length -1;
        while (first < last) {
            int sum1 = a[first] + a[last];
            if (sum1 == sum) return true;
            if(sum1 > sum) last--;
            else first++;
        }
        return false;
    }

    /**
     * 4. http://www.geeksforgeeks.org/find-smallest-subarray-contains-elements-order/
     *
     * Given two arrays of integers of size m and n. The task is to find the minimum length
     * subarray in the first array that contains all the elements of second array.
     *
     * @param a
     * @param b
     * @return
     */
    public int sizeOfSmallestSubsetWithAllElements(int[] a, int[] b) {
        int aLength = a.length;
        int bLength = b.length;
        int result = Integer.MAX_VALUE;
        for (int i =0 ; i < aLength - bLength + 1; i++) {
            if (a[i] == b[0]) {

                int j= 0;
                int index = i;
                for (;index < aLength; index++) {
                    if (a[index] == b[j]) {
                        j++;
                    }
                    if (j == bLength) {
                        break;
                    }
                }
                if (j == bLength && result > index - i + 1) {
                    result = (index == aLength)? index - i : index - i + 1;
                }
            }
        }
        return (result == Integer.MAX_VALUE)? -1 : result;
    }

    /**
     * 5. http://www.geeksforgeeks.org/generate-original-array-array-store-counts-greater-elements-right/
     *
     * Given an array of integers greater[] in which every value of array represent
     * how many elements are greater to it’s on right side in an unknown array arr[].
     * Our task is to generate original array arr[]. It may be assumed that the original
     * array contains elements in range from 1 to n and all elements are unique.
     *
     * @param greater - arr that contains number of elements greater
     * @return
     */
    public int[] originalArrayWhenGreaterGiven(int[] greater) {
        List<Integer> temp = new ArrayList<>(greater.length);
        for (int i = 0; i < greater.length; i++) {
            temp.add(i+1);
        }

        int n = greater.length;
        int[] original = new int[greater.length];

        for (int i =0; i < greater.length; i++) {
            int number = n-greater[i]-i-1;
            original[i] = temp.get(number);
            temp.remove(number);
        }
        return original;
    }

    /**
     * 6. http://www.geeksforgeeks.org/maximizing-array-sum-with-given-operation/
     * There is an array consisting of (2 * n – 1) integers. We can change sign of
     * exactly n elements in the array. In other words, we can select exactly n array elements,
     * and multiply each of them by -1. Find the maximum sum of the array.
     *
     * @param aArray - array that contains integer
     * @return maximum possible sum of array
     */
    public int findMaximumSumForGivenOperation(int[] aArray) {
        List<Integer> list = new ArrayList<>();
        int n = (aArray.length + 1)/2;
        int sum = 0;
        int negativeCount = 0;
        for (int a : aArray) {
            if (a < 0) {
                list.add(a);
                negativeCount++;
            }
            sum += Math.abs(a);
        }
        if (negativeCount > n) {
            // we need to only find last n-negativeElements and need to use something else
            // rather than sorting it. Can use linkedList to sort when inserting
            list.sort(Collections.reverseOrder());
            int extraElementsAddedToSum = negativeCount-n;
            for (int i=0; i < extraElementsAddedToSum; i++) {
                sum += list.get(i)*2;
            }
        }
        return sum;
    }

    /**
     * Alternate Solution.
     *
     * @param arr
     * @return
     */
    public int findMaximumSumForGivenOperation_alternate(int arr[]) {
        int neg = 0;
        int sum = 0;
        int m = Integer.MAX_VALUE;
        int max_sum;
        int n = (arr.length + 1)/2;

        // step 1
        for (int i = 0; i < 2 * n - 1; i++) {

            // step 2
            neg += (arr[i] < 0) ? 1 : 0;

            // step 3
            sum += Math.abs(arr[i]);

            // step 4
            m = Math.min(m, Math.abs(arr[i]));
        }

        // step 5
        if (neg % 2 == 1 && n % 2 == 0) {
            max_sum = (sum - 2 * m);
            return (max_sum);
        }

        max_sum = sum;
        return (max_sum);
    }

    /**
     * 8. http://www.geeksforgeeks.org/longest-sequence-positive-integers-array/
     *
     * Find the longest running positive sequence in an array.
     *
     * @param arr
     * @return
     */
    public int getLongestPositiveNumberSequence(int[] arr) {
        int max = 0;
        int count = 0;
        for (int anArr : arr) {
            if (anArr <= 0) {
                if (count > max) {
                    max = count;
                    count = 0;
                }
            } else {
                count++;
            }
        }
        return max > count? max : count;
    }


}
