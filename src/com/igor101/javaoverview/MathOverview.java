package com.igor101.javaoverview;

public class MathOverview {
    public static void main(String[] args) {
        var x = 3;
        var y = 2;

        System.out.printf("%d + %d = %d\n", x, y, x + y);
        System.out.printf("%d - %d = %d\n", x, y, x - y);
        System.out.printf("%d / %d = %d\n", x, y, x / y);
        System.out.printf("%d * %d = %d\n", x, y, x * y);
        System.out.printf("%d %% %d = %d\n", x, y, x % y);
        System.out.printf("%d / %d = %g (as double) \n", x, y,
                x / (double) y);
        System.out.println();

        //increase/decrease by 1
        x++; //also ++x, x=+1
        y++; //also ++y, y=+1
        System.out.printf("Increased by 1 x: %d, decreased by 1 y: %d\n",
                x, y);
        System.out.println();

        var dNum = 2.6;
        System.out.printf("floor(%.1f): %.1f\n", dNum, Math.floor(dNum));
        System.out.printf("ceil(%.1f): %.1f\n", dNum, Math.ceil(dNum));
        System.out.printf("round(%.1f): %d\n", dNum, Math.round(dNum));
        System.out.printf("sqrt(4): %.1f\n", Math.sqrt(4));
        System.out.printf("pow(2, 2): %.1f\n", Math.pow(2, 2));
    }
}
