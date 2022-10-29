package com.igor101.javaoverview;

import java.util.*;

public class OopOverview {
    public static void main(String[] args) {
        var u1 = new User(1, "some user");
        var u2 = new User(1, "some user2");
        u2.setName("some user");

        //equals is not called when we compare references!
        if (u1 != u2) {
            System.out.println("u1 is not equal to u2, comparing references");
        }
        if (u1.equals(u2)) {
            System.out.println("u1 equal to u2, calling equals()");
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
        System.out.printf("Users set: %s\n", usersMap);
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
        System.out.println();

        UserRepository repository = new InMemoryUserRepository();
        repository.create(new User(2, "new user"));
        System.out.printf("User of id 2 = %s\n", repository.ofId(2));
        System.out.printf("User of id 22 = %s\n", repository.ofId(22));
    }

    //static needed only because these are inner classes
    //normally we define them in a separate file,
    //and it's not needed!
    static class User {

        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o instanceof User u) {
                return id == u.id && Objects.equals(name, u.name);
            }

            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        @Override
        public String toString() {
            return "User[id=%d, name=%s]".formatted(id, name);
        }
    }

    record ImmutableUser(int id, String name) {
    }

    static abstract class Shape {

        public final String name;

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
            return "Triangle[%d, %d, %d]".formatted(a, b, c);
        }
    }

    enum Gender {
        MALE, FEMALE, OTHER
    }

    interface UserRepository {

        void create(User user);

        Optional<User> ofId(int userId);
    }

    static class InMemoryUserRepository implements UserRepository {

        private final Map<Integer, User> users = new HashMap<>();

        @Override
        public void create(User user) {
            users.put(user.id, user);
        }

        @Override
        public Optional<User> ofId(int userId) {
            return Optional.ofNullable(users.get(userId));
        }
    }
}
