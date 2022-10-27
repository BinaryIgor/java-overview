package com.igor101.javaoverview;

public class TypesOverview {
    public static void main(String[] args) {
        byte byteVar = 33;
        Byte nullableByteVar = 33;
        char charVar = 'b';
        Character nullableCharVar = 'b';

        short shortVar = 22;
        Short nullableShortVar = 22;
        int intVar = 33;
        Integer nullableIntVar = 33;
        long longVar = 44;
        Long nullableLongVar = 44L;

        float floatVar = 22.0F;
        Float nullableFloatVar = 22.0F;
        double doubleVar = 44.5;
        Double nullableDoubleVar = 44.5;

        String stringVar = "Some text";

        byte[] byteArray = new byte[] {0, 2};
        System.out.println(byteArray[0]);

        Double[] nullableDoubleArray = new Double[5];
        nullableDoubleArray[1] = null;
        nullableDoubleArray[2] = 44.5;
        System.out.println(nullableDoubleArray[1]);
        System.out.println(nullableDoubleArray[2]);
    }
}
