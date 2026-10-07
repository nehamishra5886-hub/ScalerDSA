package com.learning.dsa;
import java.util.logging.Level;
import java.util.logging.Logger;


//
// Problem Description
//
//Given a 2D Matrix A of dimensions N*N, we need to return the sum of all possible submatrices.
//
//
//
//Problem Constraints
//
//1 <= N <=30
//
//0 <= A[i][j] <= 10
//
//
//
//Input Format
//
//Single argument representing a 2-D array A of size N x N.
//
//
//
//Output Format
//
//Return an integer denoting the sum of all possible submatrices in the given matrix.
//
//
//
//Example Input
//
//Input 1:
//A = [ [1, 1]
//      [1, 1] ]
//Input 2:
//A = [ [1, 2]
//      [3, 4] ]
//
//
//Example Output
//
//Output 1:
//16
//Output 2:
//40
//
//
//Example Explanation
//
//Example 1:
//Number of submatrices with 1 elements = 4, so sum of all such submatrices = 4 * 1 = 4
//Number of submatrices with 2 elements = 4, so sum of all such submatrices = 4 * 2 = 8
//Number of submatrices with 3 elements = 0
//Number of submatrices with 4 elements = 1, so sum of such submatrix = 4
//Total Sum = 4+8+4 = 16
//Example 2:
//The submatrices are [1], [2], [3], [4], [1, 2], [3, 4], [1, 3], [2, 4] and [[1, 2], [3, 4]].
//Total sum = 40
//
public class SumAllSubMatrices {

    private static final Logger logger =
            Logger.getLogger(SumAllSubMatrices.class.getName());
    public static void main(String[] args) {
        int [][] A = {{1,1},{1,1}};
        sumAll(A);

    }

    public static void sumAll(int [][] A) {
        long sum = 0;
        int n = A.length;

        for (int i=0; i<n ; i++) {
            for(int j=0; j<n; j++) {
                long toLeft = (long)(i+1) * (j+1);
                long bottomRight = (long)(n-i) * (n-j);


                if (logger.isLoggable(Level.INFO)) {
                    logger.info("i = %d j = %d topleft = %d bottomright = %d"
                            .formatted(i, j, toLeft, bottomRight));

                    logger.info("sum before = %d  A[i][j] = %d"
                            .formatted(sum, A[i][j]));
                }
                sum+= A[i][j] * toLeft *bottomRight;
                if (logger.isLoggable(Level.INFO)) {
                    logger.info("sum after = %d".formatted(sum));
                }
            }
        }



    }
}
