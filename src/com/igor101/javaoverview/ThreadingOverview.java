package com.igor101.javaoverview;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class ThreadingOverview {
    public static void main(String[] args) throws Exception {
        var thread = new Thread(ThreadingOverview::someFunction);
        thread.start();
        //wait for thread end
        thread.join();

        System.out.println("Thread finished, let's start the executor...");
        System.out.println();

        var executor = Executors.newFixedThreadPool(5);

        var futures = Stream.generate(
                        () -> executor.submit(ThreadingOverview::someFunction))
                .limit(10)
                .toList();

        var results = new ArrayList<Long>();
        for (var f : futures) {
            results.add(f.get());
        }

        executor.shutdown();

        System.out.printf("Results: %s\n", results);
    }

    static long someFunction() {
        try {
            System.out.println("About to sleep in a thread..."
                    + Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.println("Wake up!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return System.currentTimeMillis();
    }
}
