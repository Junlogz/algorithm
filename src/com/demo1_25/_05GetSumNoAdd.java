package com.demo1_25;

/**
 * @author: JunLog
 * @Description: 力扣面试题 17.01不用+求两数和
 * Date: 2022/8/9 10:27
 */
public class _05GetSumNoAdd {

    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }

    public int getSum1(int a, int b) {
        while (b != 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;

            a = sum;
            b = carry;
        }
        return a;
    }

}
