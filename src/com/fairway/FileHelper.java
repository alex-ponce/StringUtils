package com.fairway;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.IntPredicate;

/**
 * Created by alexponce on 8/11/16.
 */
public class FileHelper {

    public static String readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }

            return sb.toString();
        }
        finally {
            br.close();
        }
    }

    public static String removeExtendedChars(String val) {
        val = stripChars(val, c -> c > '\u001F' && c != '\u007F');
        return stripChars(val, c -> c > '\u001F' && c < '\u007F');
    }


    private static String stripChars(String s, IntPredicate include) {
        return s.codePoints().filter(include::test).collect(StringBuilder::new,
                StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }

}
