package com.practise.arrays;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EasyArrayQuestions1Test {

    private EasyArrayQuestions1 easyArrayQuestions1;

    @Before
    public void setup() {
        this.easyArrayQuestions1 = new EasyArrayQuestions1();
    }

    @Test
    public void pairsDivisibleBy4_with_array_of_size_2(){
        int[] a = {1,2};
        int count = easyArrayQuestions1.pairsDivisibleBy4(a);
        Assert.assertEquals(0, count);
    }

    @Test
    public void pairsDivisibleBy4_with_array_of_size_6(){
        int[] a = {4, 8, 12, 1, 3, 2, 2, 6, 5, 7};
        int count = easyArrayQuestions1.pairsDivisibleBy4(a);
        Assert.assertEquals(10, count);
    }

    @Test
    public void pairsDivisibleBy4_with_array_of_size_1(){
        int[] a = {4};
        int count = easyArrayQuestions1.pairsDivisibleBy4(a);
        Assert.assertEquals(0, count);
    }

    @Test
    public void  getMaximumSizeSubsetForGivenSum_positive_testcase_with_arraysize_2() {
        int[] a = {1, 2};
        int output = this.easyArrayQuestions1.getMaximumSizeSubsetForGivenSum(a, 3);
        Assert.assertEquals(output, 2);
    }

    @Test
    public void getMaximumSizeSubsetForGivenSum_positive_testcase_with_arraysize_4() {
        int[] a = {1, 2, 4};
        int output = this.easyArrayQuestions1.getMaximumSizeSubsetForGivenSum(a, 4);
        Assert.assertEquals(output, 1);
    }

    @Test
    public void getMaximumSizeSubsetForGivenSum_positive_testcase_with_arraysize_7() {
        int[] a = {1, 2, 4, 3, 8, 5, 1};
        int output = this.easyArrayQuestions1.getMaximumSizeSubsetForGivenSum(a, 8);
        Assert.assertEquals(output, 4);
    }

    @Test
    public void getMaximumSizeSubsetForGivenSum_negative_testcase_with_arraysize_7() {
        int[] a = {1, 2, 4, 3, 8, 5, 1};
        int output = this.easyArrayQuestions1.getMaximumSizeSubsetForGivenSum(a, 90);
        Assert.assertEquals(output, 0);
    }

    @Test
    public void isSumEqualX_positive_test_case() {
        int[] a = {1,2,3,4,5};
        Assert.assertTrue(this.easyArrayQuestions1.isSumEqualX(a, 5));
    }

    @Test
    public void isSumEqualX_negative_test_case() {
        int[] a = {1,2,2,4,5};
        Assert.assertFalse(this.easyArrayQuestions1.isSumEqualX(a, 2));
    }

    @Test
    public void sizeOfSmallestSubsetWithAllElements_positive_test_size_3_4() {
        int[] a = {1,2,3,7, 1, 2, 7};
        int[] b = {1,2,7};
        int size = this.easyArrayQuestions1.sizeOfSmallestSubsetWithAllElements(a,b);
        Assert.assertEquals(size, 3);
    }

    @Test
    public void sizeOfSmallestSubsetWithAllElements_negative_test_with_not_found() {
        int[] a = {1,2,3,7, 1, 2, 7};
        int[] b = {1,2,9};
        int size = this.easyArrayQuestions1.sizeOfSmallestSubsetWithAllElements(a,b);
        Assert.assertEquals(size, -1);
    }

    @Test
    public void sizeOfSmallestSubsetWithAllElements_positive_test_non_consequtive_subset() {
        int[] a = {1,2,3,9,7, 1, 2, 7};
        int[] b = {1,2,3,7};
        int size = this.easyArrayQuestions1.sizeOfSmallestSubsetWithAllElements(a,b);
        Assert.assertEquals(size, 5);
    }

    @Test
    public void originalArrayWhenGreaterGiven_with_size_4() {
        int[] a = {3,2,1,0};
        int[] original = this.easyArrayQuestions1.originalArrayWhenGreaterGiven(a);
        Assert.assertEquals(original[0], 1);
        Assert.assertEquals(original[3], 4);
    }

    @Test
    public void originalArrayWhenGreaterGiven_with_size_8() {
        int[] a = { 6, 3, 2, 1, 0, 1, 0 };
        int[] original = this.easyArrayQuestions1.originalArrayWhenGreaterGiven(a);
        Assert.assertEquals(original[0], 1);
        Assert.assertEquals(original[6], 3);
    }

    @Test
    public void findMaximumSumForGivenOperation_with_all_negative_elements() {
        int[] a = {-1, -100, -5, -50, -10, -15, -17};
        int maxSum = this.easyArrayQuestions1.findMaximumSumForGivenOperation(a);
        //int maxSum = this.easyArrayQuestions1.maxSum(a);
        Assert.assertEquals(100+50+17+15-10-5-1, maxSum);
    }

    @Test
    public void getLongestPositiveNumberSequence_with_all_positive() {
        int[] a = {1,2,3,4,5};
        int count = this.easyArrayQuestions1.getLongestPositiveNumberSequence(a);
        Assert.assertEquals(5, count);
    }

    @Test
    public void getLongestPositiveNumberSequence_with_all_negative() {
        int[] a = {-1,-2,-3,-4,-5};
        int count = this.easyArrayQuestions1.getLongestPositiveNumberSequence(a);
        Assert.assertEquals(0, count);
    }

    @Test
    public void getLongestPositiveNumberSequence_with_some_negative() {
        int[] a = {-1,-2,3,4,-5};
        int count = this.easyArrayQuestions1.getLongestPositiveNumberSequence(a);
        Assert.assertEquals(2, count);
    }

    @Test
    public void getLongestPositiveNumberSequence_with_some_negative_element_in_last() {
        int[] a = {-1,-2,3,4,5};
        int count = this.easyArrayQuestions1.getLongestPositiveNumberSequence(a);
        Assert.assertEquals(3, count);
    }
}
