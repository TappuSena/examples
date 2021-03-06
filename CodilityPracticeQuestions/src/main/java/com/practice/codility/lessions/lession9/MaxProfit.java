package com.practice.codility.lessions.lession9;

/**
 * An array A consisting of N integers is given. It contains daily prices of a stock share for a period of N consecutive days. If a single share was bought on day P and sold on day Q, where 0 ≤ P ≤ Q < N, then the profit of such transaction is equal to A[Q] − A[P], provided that A[Q] ≥ A[P]. Otherwise, the transaction brings loss of A[P] − A[Q].
 * <p>
 * For example, consider the following array A consisting of six elements such that:
 * <p>
 * A[0] = 23171
 * A[1] = 21011
 * A[2] = 21123
 * A[3] = 21366
 * A[4] = 21013
 * A[5] = 21367
 * If a share was bought on day 0 and sold on day 2, a loss of 2048 would occur because A[2] − A[0] = 21123 − 23171 = −2048. If a share was bought on day 4 and sold on day 5, a profit of 354 would occur because A[5] − A[4] = 21367 − 21013 = 354. Maximum possible profit was 356. It would occur if a share was bought on day 1 and sold on day 5.
 * <p>
 * Write a function,
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given an array A consisting of N integers containing daily prices of a stock share for a period of N consecutive days, returns the maximum possible profit from one transaction during this period. The function should return 0 if it was impossible to gain any profit.
 * <p>
 * For example, given array A consisting of six elements such that:
 * <p>
 * A[0] = 23171
 * A[1] = 21011
 * A[2] = 21123
 * A[3] = 21366
 * A[4] = 21013
 * A[5] = 21367
 * the function should return 356, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [0..400,000];
 * each element of array A is an integer within the range [0..200,000].
 * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
public class MaxProfit {
    public static void main(String[] args) {
        final int[] A = { 23171, 21011, 21123, 21366, 21013, 21367 };
        System.out.println(solution(A));
    }

    private static int solution(int[] A) {
        int maxProfit = 0;
        int cumulativeProfit = 0;
        /*for (int i = 0; i < A.length; i++) {
            int buyPrice = A[i];
            for (int j = i + 1; j < A.length; j++) {
                int sellPrice = A[j];
                int profit = sellPrice - buyPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }*/

        //Read the array once.
        for (int i = 1; i < A.length; i++) {
            int profitOfTheDay = A[i] - A[i - 1];
            cumulativeProfit += profitOfTheDay;
            if (cumulativeProfit > 0) {
                if (cumulativeProfit > maxProfit) {
                    maxProfit = cumulativeProfit;
                }
            } else {
                cumulativeProfit = 0;
            }
        }
        return maxProfit;
    }
}
