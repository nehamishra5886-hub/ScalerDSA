package com.learning.dsa;

/*
Problem Description

Given an array, arr[] of size N, the task is to find the count of array indices
such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.



Problem Constraints

1 <= N <= 105
-105 <= A[i] <= 105
Sum of all elements of A <= 109


Input Format

First argument contains an array A of integers of size N


Output Format

Return the count of array indices such that removing an element from these indices
makes the sum of even-indexed and odd-indexed array elements equal.



Example Input

Input 1:
A = [2, 1, 6, 4]
Input 2:

A = [1, 1, 1]


Example Output

Output 1:
1
Output 2:

3



Example Explanation

Explanation 1:
Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1].
Therefore, the required output is 1.
Explanation 2:

Removing arr[0] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
Removing arr[1] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
Removing arr[2] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
Therefore, the required output is 3./

*/


public class EvenOddArray {
    public static void main(String[] args) {
        //int[] A = {2, 1, 6, 4};
        int[] A = {1,1,1};
        int result = countEvenOddIndices(A);
        System.out.println(result);
    }

    private static int countEvenOddIndices(int[] A) {
        int n = A.length;

        long totalEven = 0;
        long totalOdd = 0;

        for(int i =0; i<n; i++) {
            if(i%2==0) {
                totalEven += A[i];
            } else {
                totalOdd += A[i];
            }
        }

        int count = 0;
        long leftEven = 0;
        long leftOdd = 0;

        for (int i = 0; i < n; i++) {

            if(i%2==0) {
                totalEven -= A[i];
            } else {
                totalOdd -= A[i];
            }
            long newEven = leftEven + totalOdd;
            long newOdd = leftOdd + totalEven;

            if(newEven == newOdd) {
                count++;
            }

            if(i%2==0) {
                leftEven += A[i];
            } else {
                leftOdd += A[i];
            }

        }



        return count;
    }
}
