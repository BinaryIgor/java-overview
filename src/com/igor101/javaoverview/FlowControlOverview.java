package com.igor101.javaoverview;

public class FlowControlOverview {
    public static void main(String[] args) {
        var firstVar = 22;
        var secondVar = "ala";

        System.out.printf("firstVar: %d\n", firstVar);
        System.out.printf("secondVar: %s\n", secondVar);

        var ifVar = 3;

        if (ifVar == 3 && (true || false)) {
            System.out.println("if var is 3");
        } else if (ifVar >= 0) {
            System.out.println("if var is at least 0");
            if (ifVar > 0) {
                System.out.println("if var is greater than 0");
            } else {
                System.out.println("if var is 0");
            }
        } else {
            System.out.printf("if var is %d\n", ifVar);
        }

        System.out.println("For loop...");

        for (int i = 0; i < 10; i++) {
            System.out.println(i);

            if (randomNumber(0, 10) == i) {
                System.out.printf("Random same as %d index, breaking\n", i);
                break;
            }
        }

        System.out.println("While loop...");
        var n = 0;
        while (n < 10) {
            if (n == 2) {
                System.out.println("Skipping 2!");
                n = 4;
                continue;
            }
            System.out.println(n);
            ++n;
        }

        var t = 3;
        System.out.printf("Evaluating ternary operator (%d): %d\n",
                t, t > 0 ? 2 : 0);
    }

    static int randomNumber(int minNumber, int maxNumber) {
        return minNumber + (int) (Math.random() * maxNumber);
    }
}
