package com.practice.codility.lessions.lession5;

/**
 * A non-empty array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.
 * <p>
 * Array A contains only 0s and/or 1s:
 * <p>
 * 0 represents a car traveling east,
 * 1 represents a car traveling west.
 * The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.
 * <p>
 * For example, consider array A such that:
 * <p>
 * A[0] = 0
 * A[1] = 1
 * A[2] = 0
 * A[3] = 1
 * A[4] = 1
 * We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty array A of N integers, returns the number of pairs of passing cars.
 * <p>
 * The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 0
 * A[1] = 1
 * A[2] = 0
 * A[3] = 1
 * A[4] = 1
 * the function should return 5, as explained above.
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer that can have one of the following values: 0, 1.
 * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
public class PassingCars {
    public static void main(String[] args) {
        final int[] A = { 0, 1, 0, 1, 1 };
        System.out.println(solution(A));
    }

    private static int solution(int[] A) {
        int numberOfPassingCars = 0;
        int numberOfZeros = 0;
        for (int i = 0; i < A.length; i++) {
            if (numberOfPassingCars > 1000000000) {
                return -1;
            }
            if (A[i] == 0) {
                numberOfZeros += 1;
            } else {
                numberOfPassingCars += numberOfZeros;
            }
        }
        return numberOfPassingCars;
    }
}
