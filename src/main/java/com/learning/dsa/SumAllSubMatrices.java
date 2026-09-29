package com.learning.dsa;
import java.util.logging.Level;
import java.util.logging.Logger;
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
