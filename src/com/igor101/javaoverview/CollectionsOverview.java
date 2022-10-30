package com.igor101.javaoverview;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionsOverview {
    public static void main(String[] args) {
        var numbersList = List.of(1, 2, 3, 4);
        var numbersSet = Set.of(1, 2, 3, 4);
        var numbersMap = Map.of("a", 1, "b", 2,
                "c", 3, "d", 4);

        System.out.printf("List of size (%d): %s\n", numbersList.size(), numbersList);
        System.out.printf("Set of size (%d): %s\n", numbersSet.size(), numbersSet);
        System.out.printf("Map of size (%d): %s\n", numbersMap.size(), numbersMap);
        System.out.println();

        System.out.println("Iterating over list:");
        for (var v : numbersList) System.out.println(v);

        System.out.println("Iterating over map:");
        numbersMap.forEach((k, v) -> System.out.printf("%s - %d\n", k, v));

        var evenNumbersList = numbersList.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toCollection(LinkedList::new));
        var oddNumbersList = numbersList.stream()
                .filter(n -> n % 2 == 1)
                .toList();
        var oddNumbersReversedList = numbersList.stream()
                .filter(n -> n % 2 == 1)
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.printf("Even numbers list: %s\n", evenNumbersList);
        System.out.printf("Odd numbers list: %s\n", oddNumbersList);
        System.out.printf("Odd numbers reversed list: %s\n", oddNumbersReversedList);

        var stringList = new ArrayList<String>();
        stringList.add("a");
        stringList.add("b");
        stringList.addAll(List.of("a1", "b2"));
        System.out.printf("Mutated string list: %s\n", stringList);
        System.out.println();

        System.out.printf("Sublist: %s\n", stringList.subList(1, 3));

        var reversedStringList = new ArrayList<>(stringList);
        Collections.reverse(reversedStringList);
        System.out.printf("Reversed sublist: %s\n", reversedStringList.subList(1, 4));
        System.out.println();

        var stringMap = new HashMap<String, String>();
        stringMap.put("a", "a-value");
        stringMap.put("b", "b-value");
        stringMap.putAll(Map.of("c", "c-value", "d", "d-value"));
        System.out.printf("Mutated string map: %s\n", stringMap);
    }
}
