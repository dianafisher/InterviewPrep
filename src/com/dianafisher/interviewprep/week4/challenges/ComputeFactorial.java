package com.dianafisher.interviewprep.week4.challenges;

/**
 * Created by dianafisher on 1/16/18.
 */

import java.math.BigInteger;

public class ComputeFactorial {

    static final BigInteger one = new BigInteger("1");

    public BigInteger factorial(BigInteger n) {
//        System.out.println("n = " + n);
        if (n.equals(one)) {
            return one;
        }

        BigInteger prev = n.subtract(one);

        return n.multiply(factorial(prev));
    }

    public static void main(String[] args) {
        ComputeFactorial cf = new ComputeFactorial();
        System.out.println(cf.factorial(new BigInteger("5")));
    }


}
