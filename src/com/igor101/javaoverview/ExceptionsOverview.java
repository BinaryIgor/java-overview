package com.igor101.javaoverview;

import java.util.List;

public class ExceptionsOverview {
    public static void main(String[] args) {
        try {
            throw new CustomException("Some exception...");
        } catch (Throwable e) {
            System.err.println("Handling exception...");
            e.printStackTrace();
        }

        System.err.println();

        try {
            List.of("a").add("b");
        } catch (UnsupportedOperationException e) {
            System.err.printf("Can't add to immutable list...%s\n", e);
            e.printStackTrace();
        }
    }

    static class CustomException extends Exception {
        CustomException(String message) {
            super(message);
        }
    }
}
