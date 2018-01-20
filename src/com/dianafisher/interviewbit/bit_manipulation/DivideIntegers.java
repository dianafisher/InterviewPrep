package com.dianafisher.interviewbit.bit_manipulation;

/**
 * Created by dianafisher on 1/20/18.
 *
 * Divide two integers without using multiplication, division and mod operator.

 Return the floor of the result of the division.

 Example:

 5 / 2 = 2

 Also, consider if there can be overflow cases. For overflow case, return INT_MAX.

 */
public class DivideIntegers {

    public int divide(int A, int B) {
        // A >> x is equal to division by pow(2,x)

        if (B == 0) return Integer.MAX_VALUE;
        if (B == -1 && A == Integer.MIN_VALUE) return Integer.MAX_VALUE;

        if (A == B) return 1;

        long numerator = Math.abs((long)A);
        long denominator = Math.abs((long)B);


        int result = 0;
        while(numerator>=denominator){

            int count = 0;
            while(numerator >= (denominator << count )){
                count++;
            }

            result += 1 << (count-1);
            numerator -= (denominator << (count-1));
        }

        if(( A > 0 && B > 0) || (A < 0 && B < 0)){
            return result;
        } else{
            return -result;
        }
    }

    public int editorialDivide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == divisor) return 1;
        if (divisor == 1) return dividend;
        if (divisor == -1) return -dividend;
        if (divisor == 2) return (dividend >> 1);
        return (int) div(dividend, divisor);
    }

    public long div(long dividend, long divisor) {
        long ans=0;
        boolean sign =  false;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            sign = true;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while(dividend>0){
            dividend-= divisor;
            ans++;
        }
        if(dividend<0)
            ans=ans-1;
        return sign? -ans : ans;
    }


    public int naiveDivide(int A, int B) {
        if (B == 0) return Integer.MAX_VALUE;
        if (B == -1 && A == Integer.MIN_VALUE) return Integer.MAX_VALUE;

        if (A == B) return 1;

        long numerator = Math.abs((long)A);
        long denominator = Math.abs((long)B);

        int count = 0;

        while (numerator > denominator) {
            numerator -= denominator;
            count++;
        }

        return count;

    }

    public static void main(String[] args) {
        DivideIntegers d = new DivideIntegers();
        System.out.println(d.divide(5, 2));  // 2
        System.out.println(d.divide(2, 1));  // 2
        System.out.println(d.divide(2147483647, 1));   // 2147483647
    }

}
