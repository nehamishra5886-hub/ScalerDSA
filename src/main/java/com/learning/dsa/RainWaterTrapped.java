package com.learning.dsa;

/*Problem Description

Imagine a histogram where the bars' heights are given by the array A. Each bar is of uniform width, which is 1 unit. When it rains, water will accumulate in the valleys between the bars.

Your task is to calculate the total amount of water that can be trapped in these valleys.

Example:

The Array A = [5, 4, 1, 4, 3, 2, 7] is visualized as below. The total amount of rain water trapped in A is 11.
Input Format

First and only argument is the Integer Array, A.



Output Format

Return an Integer, denoting the total amount of water that can be trapped in these valleys



Example Input

Input 1:

 A = [0, 1, 0, 2]
Input 2:

A = [1, 2]


Example Output

Output 1:

1
Output 2:

0


Example Explanation

Explanation 1:

1 unit is trapped on top of the 3rd element.
Rain Water Histogram
Explanation 2:

No water is trapped.

* */
public class RainWaterTrapped {
    public static void main(String[] args) {
        //int[] A = {5, 4, 1, 4, 3, 2, 7};
        //int[] A = {0, 1, 0, 2};
        int[] A = {1, 2};
        System.out.println(trap(A));
    }

    private static int trap(int[] A) {
        int n = A.length;

        if(n==0) return 0;

        int left = 0, right = n - 1;
        int [] leftMax = new int[n];
        int [] rightMax = new int[n];
        int trappedWater = 0;

        //Step 1 compute left max array
        leftMax[0] = A[0];
        for(int i=1 ;i<n;i++){
            leftMax[i] = Math.max(leftMax[i-1], A[i]);
        }

        //Step 2 compute right max array
        rightMax[n-1] = A[n-1];
        for(int i=n-2; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1], A[i]);
    }

        //Step 3 calculate trapped water
        //Formula : TRappedWater[i] = min(LeftMax[i], RightMax[i]) - A[i]
        for(int i=0; i<n; i++){
            trappedWater += Math.min(leftMax[i], rightMax[i]) - A[i];
        }

        return trappedWater;
    }

}
