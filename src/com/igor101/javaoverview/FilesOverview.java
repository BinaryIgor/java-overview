package com.igor101.javaoverview;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FilesOverview {
    public static void main(String[] args) throws Exception {
        var fileContent = """
                Some text file
                of multiple lines
                """.strip();

        var textFilePath = "/tmp/tmp_file.txt";

        var binaryFilePath = "files/forest.jpg";

        var dirPath = "/tmp/dir";

        Files.writeString(Path.of(textFilePath), fileContent);

        var txtContent = Files.readString(Path.of(textFilePath));
        System.out.printf("File: %s content: %n", textFilePath);
        System.out.println(txtContent.getClass());
        System.out.println(txtContent);

        try (var is = new FileInputStream(binaryFilePath)) {
            var binaryFileContent = is.readAllBytes();
            System.out.println(binaryFileContent.getClass());
            System.out.println(binaryFileContent.length);
        }

        var dirPathObject = Path.of(dirPath);
        System.out.println();
        System.out.printf("Does %s exist?: %s%n", dirPath,
                Files.exists(dirPathObject));

        if (!Files.exists(dirPathObject)) {
            Files.createDirectory(dirPathObject);
        }

        System.out.printf("Files in: %s - %s%n",
                dirPath, Files.list(dirPathObject).toList());

        Files.copy(Path.of(textFilePath), Path.of(dirPath, "txt_file.txt"),
                StandardCopyOption.REPLACE_EXISTING);
        Files.copy(Path.of(binaryFilePath), Path.of(dirPath, "binary_file.jpg"),
                StandardCopyOption.REPLACE_EXISTING);

        System.out.printf("After copying files: %s - %s%n",
                dirPath, Files.list(dirPathObject).toList());
    }
}
