package org.m4bank;

import java.io.File;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

@SuppressWarnings("unused")
public final class FileResourceUtils {

    private FileResourceUtils() {
    }

    // get a file from the resources folder
    // works everywhere, IDEA, unit test and JAR file.
    public static InputStream getFileFromResourceAsStream(String fileName) {

        // The class loader that loaded the class
        ClassLoader classLoader = FileResourceUtils.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }

    /*
        The resource URL is not working in the JAR
        If we try to access a file that is inside a JAR,
        It throws NoSuchFileException (linux), InvalidPathException (Windows)

        Resource URL Sample: file:java-io.jar!/json/file1.json
     */
    public static File getFileFromResource(String fileName) throws URISyntaxException {
        ClassLoader classLoader = FileResourceUtils.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);

        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {

            // failed if files have whitespaces or special characters
            //return new File(resource.getFile());

            return new File(resource.toURI());
        }
    }
}
