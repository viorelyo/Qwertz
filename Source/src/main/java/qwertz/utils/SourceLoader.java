package qwertz.utils;

import java.io.*;

public class SourceLoader {
    private SourceLoader() {
    }

    public static String readSource(String fileName) throws IOException {
        InputStream is = SourceLoader.class.getResourceAsStream(fileName);
        if (is != null)
            return readAndCloseStream(is);

        is = new FileInputStream(fileName);
        return readAndCloseStream(is);
    }

    public static String readAndCloseStream(InputStream is) throws IOException {
        final ByteArrayOutputStream result = new ByteArrayOutputStream();
        final int bufferSize = 1024;
        final byte[] buffer = new byte[bufferSize];
        int nRead;
        while ((nRead = is.read(buffer)) != -1) {
            result.write(buffer, 0, nRead);
        }
        is.close();
        return result.toString("UTF-8");
    }
}
