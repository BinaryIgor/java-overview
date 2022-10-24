package com.igor101.javaoverview;

public class FlowControlOverview {
    public static void main(String[] args) {
        //local type inference, same as: int firstVar = 22;
        var firstVar = 22;
        String secondVar = "ala";

        print("firstVar: %d".formatted(firstVar));
        System.out.printf("secondVar: %s%n", secondVar);

        var ifVar = 3;

        //redundant and, or - just to show syntax
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
            System.out.printf("if is: %d%n", ifVar);
        }

        System.out.println("For loop...");
        //change to i+=2 to increase the step
        for (int i = 0; i < 10; i++) {
            System.out.println(i);

            if (randomIntInRange(0, 10) == i) {
                System.out.printf("Random same as %d index, breaking!%n", i);
                break;
            }
        }

        System.out.println("While loop");
        var n = 0;
        while (n < 10) {
            if (n == 2) {
                System.out.println("Skipping 2!");
                n = 4;
                continue;
            }

            System.out.println(n);
            n++;
        }

        var switched = 44;
        switch (switched) {
            case 0:
                System.out.println("Switched is 0");
                break;
            case 2:
                System.out.println("Switched is 2");
                break;
            default:
                System.out.printf("Switched is %d%n", switched);
        }

        //ternary operator (one line if)
        var t = 3;
        System.out.printf("Evaluating ternary operator (%d): (%d)",
                t, t > 0 ? 2 : 0);
    }

    static void print(String message) {
        System.out.println(message);
    }

    static int randomIntInRange(int min, int max) {
        return min + (int) (Math.random() * max);
    }
}
