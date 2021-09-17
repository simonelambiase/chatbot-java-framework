package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class FileUtils {

    public static InputStream obtainInputStreamFromURL ( String url ) throws IOException {
        return new URL(url).openStream();
    }
}
