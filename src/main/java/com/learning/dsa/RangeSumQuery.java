package com.learning.dsa;

public class RangeSumQuery {
    public static void main(String[] args) {
        //int[] A = {1, 2, 3, 4, 5};
        //int [][] B = {{0, 3}, {1, 2}};
        //output = [ 10, 5]

        int[] A = {2,2,2};
        int [][] B = {{0, 0}, {1, 2}};
        //output = [2, 4]
        long [] result = rangeSum(A, B);
        for (long res : result) {
            System.out.print(res + " ");
            //System.out.println("Result: ");
        }


    }


    public static long[] rangeSumBF(int[] A, int[][] B) {
        long[] result = new long[B.length];

        for (int i = 0; i < B.length; i++) {
            //System.out.println(B.length);
            int l = B[i][0];
            int r = B[i][1];
            long sum = 0;
            for (int j = l ; j <= r; j++) {
                sum += A[j];
            }
            result[i] = sum;
            System.out.println(sum);
        }
        return result;
    }


    public static long[] rangeSum(int [] A, int [] [] B) {
        long [] result = new long [B.length];
        long [] prefixSum = new long[A.length];

        for (int i =0; i<A.length; i++) {
            if(i==0) {
                prefixSum[i] = A[i];
            } else {
                prefixSum[i] = prefixSum[i-1] + A[i];
            }
        }

        for (int i =0; i<B.length;i++) {
            int l = B[i][0];
            int r = B[i][1];
            if(l==0) {
                result[i] = prefixSum[r];
            } else {
                result[i] = prefixSum[r] - prefixSum[l - 1];
            }
        }

        return result;
    }
}

