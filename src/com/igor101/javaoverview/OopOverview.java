package com.igor101.javaoverview;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Objects;

public class OopOverview {
    public static void main(String[] args) {
        var u1 = new User(1, "some user");
        var u2 = new User(1, "some user2");
        u2.name = "some user";

        if (u1 == u2) {
            System.out.println("u1 is equal to u2, comparing by reference");
        } else {
            System.out.println("u1 is not equal to u2, comparing by reference");
        }
        if (u1.equals(u2)) {
            System.out.println("u1 is equal to u2");
        }

        var usersMap = new LinkedHashMap<User, String>();
        usersMap.put(u1, "a");
        usersMap.put(u2, "b");
        usersMap.put(new User(2, "another user"), "c");
        System.out.printf("Users map: %s\n", usersMap);

        var usersSet = new LinkedHashSet<User>();
        usersSet.add(u1);
        usersSet.add(u2);
        usersSet.add(new User(3, "different user"));
        System.out.printf("Users set: %s\n", usersSet);
        System.out.println();

        System.out.printf("Immutable user: %s\n",
                new ImmutableUser(1, "ala"));

        if (new ImmutableUser(1, "ala")
                .equals(new ImmutableUser(1, "ala"))) {
            System.out.println("Equal immutable users");
        }
        System.out.println();

        var triangle = new Triangle(1, 2, 2);
        System.out.printf("Triangle (%s) perimeter: %d\n", triangle,
                triangle.perimeter());
        System.out.printf("Equilateral triangle: %s\n", Triangle.equilateral(2));
        System.out.println();

        System.out.printf("All Gender enums: (%s)\n",
                Arrays.toString(Gender.values()));
    }

    static class User {
        public long id;
        public String name;

        public User(long id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User(%d, %s)".formatted(id, name);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (obj == this) return true;

            if (obj instanceof User u) {
                return id == u.id && name.equals(u.name);
            }

            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    record ImmutableUser(long id, String name) {
    }

    static abstract class Shape {

        protected final String name;

        public Shape(String name) {
            this.name = name;
        }

        public abstract int perimeter();
    }

    static class Triangle extends Shape {

        private final int a;
        private final int b;
        private final int c;

        public Triangle(int a, int b, int c) {
            super("Triangle");
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public static Triangle equilateral(int a) {
            return new Triangle(a, a, a);
        }

        @Override
        public int perimeter() {
            return a + b + c;
        }

        @Override
        public String toString() {
            return "Triangle(%d, %d, %d)".formatted(a, b, c);
        }
    }

    enum Gender {
        MALE, FEMALE, OTHER
    }
}
