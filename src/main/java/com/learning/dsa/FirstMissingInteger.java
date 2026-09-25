package com.learning.dsa;
//
// Problem Description
//
//Given an unsorted integer array, A of size N. Find the first missing positive integer.
//Note: Your algorithm should run in O(n) time and use constant space.Problem Constraints
//
//1 <= N <= 1000000
//-109 <= A[i] <= 109
//
//
//
//Input Format
//First argument is an integer array A.
//
//Output Format
//
//Return an integer denoting the first missing positive integer.
//
//Example Input
//
//Input 1:
//
//[1, 2, 0]
//Input 2:
//
//[3, 4, -1, 1]
//Input 3:
//
//[-8, -7, -6]
//
//Example Output
//
//Output 1:
//
//3
//Output 2:
//
//2
//Output 3:
//
//1
//
//
//Example Explanation
//
//Explanation 1:
//
//A = [1, 2, 0]
//First positive integer missing from the array is 3.
//Explanation 2:
//
//A = [3, 4, -1, 1]
//First positive integer missing from the array is 2.
//Explanation 3:
//
//A = [-8, -7, -6]
//First positive integer missing from the array is 1.
// */

public class FirstMissingInteger {
    public static void main(String[] args) {
        int[] A = {1,2,0};
        //int[] A = {3,4,-1, -1};
        //int[] A = {-8,-7,-6};

        int result = firstMissingPositive(A);
        System.out.println("First missing positive integer "+result);

    }

    public static int firstMissingPositive(int[] A) {
        int n = A.length;
        //Step 1: Place each number at its correct location
        for(int i =0; i< n ;i++ ){
            while(A[i] >0 && A[i]<=n && A[A[i] -1 ]!= A[i]) {
                int temp = A[A[i] -1];
                A[A[i]-1] = A[i];
                A[i] = temp;

            }
        }

        //Step 2 - Find the first index where A[i] != i+1
        for(int i=0; i<n ; i++) {
            if(A[i] != i+1) {
                return  i+1;
            }
        }

        //Step 3- If All in place return n+1
        return n+1;
    }

}
