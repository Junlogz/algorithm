package com.demo1_25;

/**
 * @author: JunLog
 * @Description: *
 * Date: 2022/8/9 12:04
 */
public class _10NumPwo {

    public static void main(String[] args) {
        powFast(2, 7);
    }

    public double pow(double x, int n) {
        double result = 1;
        long N = Math.abs((long) n);

        for (long i = 0; i < N; i++) {
            result *= x;
        }
        return n < 0 ? 1/result : result;
    }

    public static double powFast(double x, int n) {
        double result = 1;
        long N = Math.abs((long) n);

        while (N != 0) {
            if ((N & 1) == 1) result *= x;
            x *= x;
            N >>= 1;
        }
        return n < 0 ? 1/result : result;
    }



}
