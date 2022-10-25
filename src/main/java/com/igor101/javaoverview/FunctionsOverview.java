package com.igor101.javaoverview;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class FunctionsOverview {
    public static void main(String[] args) {
        var a = 3;
        var b = 4;

        System.out.println(add(a, b));
        System.out.println(nestedAdd(a, b));

        defaultArgFunction(a);
        defaultArgFunction(a, b);

        System.out.println("....");
        variableArgsFunction();
        variableArgsFunction(2);
        variableArgsFunction(2, "two");
        variableArgsFunction(new Object[]{2, "three"});

        System.out.println("....");

        BiFunction<Integer, Integer, Integer> funcVar = FunctionsOverview::add;
        System.out.println(funcVar.apply(2, 3));

        var closedAdd = addFunction(2, 3);
        System.out.println(closedAdd.get());

        BiFunction<Integer, Integer, Integer> lambdaVar = (x, y) -> x + y;
        System.out.println(lambdaVar.apply(2, 3));
    }

    static int add(int a, int b) {
        System.out.printf("Calling add (%d, %d)!%n", a, b);
        return a + b;
    }

    static int nestedAdd(int a, int b) {
        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
        System.out.printf("Calling nested add (%d, %d)!%n", a, b);
        return add.apply(a, b);
    }

    static Supplier<Integer> addFunction(int a, int b) {
        return () -> a + b;
    }

    static void defaultArgFunction(int a, Integer b) {
        System.out.printf("Calling default arg function...%d, %d%n", a, b);
    }

    static void defaultArgFunction(int a) {
        defaultArgFunction(a, null);
    }

    static void variableArgsFunction(Object...args) {
        System.out.printf("Variable args function: %s%n", Arrays.toString(args));
    }
}
