package utils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {

    public static InputStream obtainInputStreamFromURL ( String url ) throws IOException {
        return new URL(url).openStream();
    }

    public static void downloadFileFromStream (InputStream is ) throws IOException {
        Files.copy(is, Paths.get("resources/download"));
    }
}
