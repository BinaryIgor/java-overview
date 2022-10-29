package com.igor101.javaoverview;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DatetimeOverview {
    public static void main(String[] args) {
        System.out.println("Current timestamp 1: " + System.currentTimeMillis());
        System.out.println("Current timestamp 2: "
                + Instant.now().toEpochMilli());
        System.out.printf("Current datetime (local): %s\n", LocalDateTime.now());
        System.out.printf("Current datetime (UTC): %s\n",
                LocalDateTime.now(ZoneId.of("UTC")));
        System.out.printf("Current date: %s\n", LocalDate.now());

        var datetimeIsoStr = "2022-10-24T21:49:24";
        var dateIsoStr = "2022-10-24";
        System.out.printf("Datetime from iso str: %s\n",
                LocalDateTime.parse(datetimeIsoStr));
        System.out.printf("Date from iso str: %s\n", LocalDate.parse(dateIsoStr));
    }
}
