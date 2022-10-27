package com.igor101.javaoverview;

import java.util.List;

public class ExceptionsOverview {
    public static void main(String[] args) {
        try {
            throw new CustomException("Some exception");
        } catch (Exception e) {
            System.err.println("Handling exception...");
            e.printStackTrace();
        }

        System.err.println();

        try {
            List.of().add("Immutable list!");
        } catch (UnsupportedOperationException e) {
            System.err.println("Can't add element to immutable collection..." + e);
            e.printStackTrace();
        }
    }

    static class CustomException extends RuntimeException {
        public CustomException(String message) {
            super(message);
        }
    }
}
