package com.igor101.javaoverview;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringsOverview {
    public static void main(String[] args) {
        var oneLineStr = "some string";
        var multilineStr = """
                multiline string, line1
                line 2""";

        System.out.println(oneLineStr);
        System.out.printf("Substring (2, end): %s\n",
                oneLineStr.substring(2));
        System.out.printf("Substring (1, 4): %s\n", oneLineStr.substring(1, 4));
        System.out.printf("Is l in %s?: %s\n", oneLineStr,
                oneLineStr.contains("l"));
        System.out.printf("Is s in %s?: %s\n", oneLineStr,
                oneLineStr.contains("s"));
        System.out.println();

        var anotherStr = "some different text";
        System.out.printf("Index of k in %s: %s\n", anotherStr,
                anotherStr.indexOf("k"));
        System.out.printf("Index of d in %s: %s\n", anotherStr,
                anotherStr.indexOf("d"));
        System.out.printf("Replace white spaces with 1 in %s: %s\n",
                anotherStr, anotherStr.replace(" ", "1"));
        System.out.printf("To uppercase: %s\n", anotherStr.toUpperCase());
        System.out.printf("TO LOWER CASE: %s\n", "TO_LOWER_CASE".toLowerCase());
        System.out.println();

        var toStripStr = "  with too many white spaces \t";
        System.out.printf("Stripped |%s|: |%s|\n", toStripStr, toStripStr.strip());

        var toSplitStr = "a | b | c | yet another character";
        System.out.printf("To split str: %s, split: %s\n", toSplitStr,
                Arrays.toString(toSplitStr.split("\\|")));

        var yetAnotherString = "yet another string";
        System.out.printf("%s starts with 'yet'? %s\n", yetAnotherString,
                yetAnotherString.startsWith("yet"));
        System.out.printf("%s starts with 'et'? %s\n", yetAnotherString,
                yetAnotherString.startsWith("et"));
        System.out.printf("%s ends with 'ing'? %s\n", yetAnotherString,
                yetAnotherString.endsWith("ing"));
        System.out.printf("%s ends with 'in'? %s\n", yetAnotherString,
                yetAnotherString.endsWith("in"));
        System.out.println();

        var regexStr = "a|sth|z";
        var regex = Pattern.compile("^a(.*)z$");
        var rMatch = regex.matcher(regexStr);
        rMatch.find();
        System.out.printf("%s matches regex(%s): %s\n", regexStr,
                regex.pattern(), rMatch.group(1));
    }
}

