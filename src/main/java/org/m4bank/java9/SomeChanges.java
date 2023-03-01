package org.m4bank.java9;

import org.m4bank.FileResourceUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

@SuppressWarnings("unused")
public final class SomeChanges {

    private SomeChanges() {
    }

    public static void printProcessPID() {
        ProcessHandle currentProcess = ProcessHandle.current();

        System.out.println("Current Process Id: = " + currentProcess.pid());
    }

    public static void fileReadBeforeJava9() throws IOException, URISyntaxException {
        BufferedReader reader1 = new BufferedReader(
                new FileReader(FileResourceUtils.getFileFromResource("test.txt")));

        try (BufferedReader reader2 = reader1) {
            System.out.println(reader2.readLine());
        }
    }

    public static void fileReadJava9() throws IOException, URISyntaxException {
        BufferedReader reader1 = new BufferedReader(
                new FileReader(FileResourceUtils.getFileFromResource("test.txt")));

        try (reader1) {
            System.out.println(reader1.readLine());
            System.out.println(reader1.readLine());
            System.out.println(reader1.readLine());
        }

    }
}
