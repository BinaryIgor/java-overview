package com.igor101.javaoverview;

public class MiscellaneousOverview {
    public static void main(String[] args) {
        System.out.println("All env variables:");
        for (var k : System.getenv().keySet())
            System.out.println(k);

        System.out.println();
        System.out.printf("PATH env variable: %s\n",
                System.getenv().get("PATH"));
    }
}
