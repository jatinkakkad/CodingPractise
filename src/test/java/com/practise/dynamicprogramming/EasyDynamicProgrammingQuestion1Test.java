package com.practise.dynamicprogramming;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EasyDynamicProgrammingQuestion1Test {

    private EasyDynamicProgrammingQuestion1 easyDynamicProgrammingQuestion1;

    @Before
    public void setup() {
        this.easyDynamicProgrammingQuestion1 = new EasyDynamicProgrammingQuestion1();
    }

    @Test
    public void maxSumOfCrossPathIn2DArray_g2g_given_example() {
        int mat[][] = { {5, 6, 1, 7},
                {-2, 10, 8, -1},
                {3, -7, -9, 11},
                {12, -4, 2, 6} };

        int maxSum = this.easyDynamicProgrammingQuestion1.maxSumOfCrossPathIn2DArray(mat);
        Assert.assertEquals(maxSum, 28);
    }

    @Test
    public void maxSumOfCrossPathIn2DArray_with_one_row() {
        int mat[][] = { {5, 6, 1, 7}};

        int maxSum = this.easyDynamicProgrammingQuestion1.maxSumOfCrossPathIn2DArray(mat);
        Assert.assertEquals(maxSum, 7);
    }

    @Test
    public void maxSumOfCrossPathIn2DArray_with_one_column() {
        int mat[][] = { {5}, {6}, {1}, {7}};

        int maxSum = this.easyDynamicProgrammingQuestion1.maxSumOfCrossPathIn2DArray(mat);
        Assert.assertEquals(maxSum, Integer.MIN_VALUE);
    }

    @Test
    public void longestIncreasingPathInMatrix_with_g4g_example() {
        int[][] arr = { { 1, 2, 3, 4 },
                { 2, 2, 3, 4 },
                { 3, 2, 3, 4 },
                { 4, 5, 6, 7 } };
        int count = this.easyDynamicProgrammingQuestion1.longestIncreasingPathInMatrix(arr);
        Assert.assertEquals(count, 7);
    }

    @Test
    public void longestIncreasingPathInMatrix_with_g4g_example2() {
        int[][] arr = { { 1, 2 },
                { 3, 4 } };
        int count = this.easyDynamicProgrammingQuestion1.longestIncreasingPathInMatrix(arr);
        Assert.assertEquals(count, 3);
    }

    @Test
    public void getMaximumSumSubAtomicSubArray_g4g_example_1() {
        int arr[] = {5, 3, 9, 2, 7, 6, 4};
        int maxSum = this.easyDynamicProgrammingQuestion1.getMaximumSumSubAtomicSubArray(arr);
        Assert.assertEquals(maxSum, 19);
    }

    @Test
    public void getMaximumSumSubAtomicSubArray_g4g_example_2() {
        int arr[] = {9, 12, 14, 8, 6, 5, 10, 20};
        int maxSum = this.easyDynamicProgrammingQuestion1.getMaximumSumSubAtomicSubArray(arr);
        Assert.assertEquals(maxSum, 54);
    }

    @Test
    public void maxLenSub_g4g_example1() {
        int arr[] = {2, 5, 6, 3, 7, 6, 5, 8};
        Assert.assertEquals(this.easyDynamicProgrammingQuestion1.maxLenSub(arr), 5);
    }

    @Test
    public void maxLenSub_g4g_example2() {
        int arr[] = {-2, -1, 5, -1, 4, 0, 3};
        Assert.assertEquals(this.easyDynamicProgrammingQuestion1.maxLenSub(arr), 4);
    }

    @Test
    public void  maxPathCount_g2g_example1(){
        int arr[][] = {{0, 0, 0},
                       {0, 1, 0},
                       {0, 0, 0}};
        Assert.assertEquals(2, this.easyDynamicProgrammingQuestion1.maxPathCount(arr, 0,0));
    }

    @Test
    public void  maxPathCount_all_zeros(){
        int arr[][] = {{0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}};
        Assert.assertEquals(6, this.easyDynamicProgrammingQuestion1.maxPathCount(arr, 0,0));
    }

    @Test
    public void  maxPathCount_with_last_element_1(){
        int arr[][] = {{0, 0, 0},
                {0, 0, 0},
                {0, 0, 1}};
        Assert.assertEquals(0, this.easyDynamicProgrammingQuestion1.maxPathCount(arr, 0,0));
    }

    @Test
    public void canAWinCoinGame_g4g_example1() {
        Assert.assertFalse(this.easyDynamicProgrammingQuestion1.canAWinCoinGame(7, 3,4));
    }

}
