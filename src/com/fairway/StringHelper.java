package com.fairway;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.function.IntPredicate;
import java.util.Map;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by alexponce on 8/11/16.
 */
public class StringHelper {

    private Map<String, String> CHAR_MAP = new HashMap<>();
    {
        CHAR_MAP.put("À", "A");
        CHAR_MAP.put("Á", "A");
        CHAR_MAP.put("Â", "A");
        CHAR_MAP.put("Ä", "A");
        CHAR_MAP.put("Æ", "AE");
        CHAR_MAP.put("Å", "A");
        CHAR_MAP.put("Ā", "A");

        CHAR_MAP.put("Ç", "C");
        CHAR_MAP.put("Ć", "C");
        CHAR_MAP.put("Č", "C");


        CHAR_MAP.put("È", "E");
        CHAR_MAP.put("É", "E");
        CHAR_MAP.put("Ê", "E");
        CHAR_MAP.put("Ë", "E");
        CHAR_MAP.put("Ē", "E");
        CHAR_MAP.put("Ė", "E");
        CHAR_MAP.put("Ę", "E");

        CHAR_MAP.put("Î", "I");
        CHAR_MAP.put("Ï", "I");
        CHAR_MAP.put("Í", "I");
        CHAR_MAP.put("Ī", "I");
        CHAR_MAP.put("Į", "I");
        CHAR_MAP.put("Ì", "I");

        CHAR_MAP.put("Ô", "O");
        CHAR_MAP.put("Ö", "O");
        CHAR_MAP.put("Ò", "O");
        CHAR_MAP.put("Œ", "OE");
        CHAR_MAP.put("Ø", "O");
        CHAR_MAP.put("Ō", "O");
        CHAR_MAP.put("Õ", "O");

        CHAR_MAP.put("Û", "U");
        CHAR_MAP.put("Ü", "U");
        CHAR_MAP.put("Ù", "U");
        CHAR_MAP.put("Ú", "U");
        CHAR_MAP.put("Ū", "U");

        CHAR_MAP.put("à", "a");
        CHAR_MAP.put("á", "a");
        CHAR_MAP.put("â", "a");
        CHAR_MAP.put("ä", "a");
        CHAR_MAP.put("æ", "ae");
        CHAR_MAP.put("ã", "a");
        CHAR_MAP.put("å", "a");
        CHAR_MAP.put("ā", "a");


        CHAR_MAP.put("ç", "c");
        CHAR_MAP.put("ć", "c");
        CHAR_MAP.put("č", "c");
        
        CHAR_MAP.put("è", "e");
        CHAR_MAP.put("é", "e");
        CHAR_MAP.put("ê", "e");
        CHAR_MAP.put("ë", "e");
        CHAR_MAP.put("ē", "e");
        CHAR_MAP.put("ė", "e");
        CHAR_MAP.put("ę", "e");

        CHAR_MAP.put("î", "i");
        CHAR_MAP.put("ï", "i");
        CHAR_MAP.put("í", "i");
        CHAR_MAP.put("ī", "i");
        CHAR_MAP.put("į", "i");
        CHAR_MAP.put("ì", "i");

        CHAR_MAP.put("ô", "o");
        CHAR_MAP.put("ö", "o");
        CHAR_MAP.put("ò", "o");
        CHAR_MAP.put("ó", "o");
        CHAR_MAP.put("œ", "oe");
        CHAR_MAP.put("ø", "o");
        CHAR_MAP.put("ō", "o");
        CHAR_MAP.put("õ", "o");
        
        CHAR_MAP.put("û", "u");
        CHAR_MAP.put("ü", "u");
        CHAR_MAP.put("ù", "u");
        CHAR_MAP.put("ú", "u");
        CHAR_MAP.put("ū", "u");

        CHAR_MAP.put("ł", "l");
        CHAR_MAP.put("Ł", "L");

        CHAR_MAP.put("ñ", "n");
        CHAR_MAP.put("ń", "n");
        CHAR_MAP.put("Ñ", "N");
        CHAR_MAP.put("Ń", "N");

        CHAR_MAP.put("ß", "s");
        CHAR_MAP.put("ś", "s");
        CHAR_MAP.put("š", "s");
        CHAR_MAP.put("Ś", "S");
        CHAR_MAP.put("Š", "S");

        CHAR_MAP.put("Ÿ", "Y");
        CHAR_MAP.put("ÿ", "y");

        CHAR_MAP.put("ž", "z");
        CHAR_MAP.put("ź", "z");
        CHAR_MAP.put("ż", "z");
        CHAR_MAP.put("Ž", "Z");
        CHAR_MAP.put("Ź", "Z");
        CHAR_MAP.put("Ż", "Z");

    }

    
    public String readFile(String fileName) throws IOException {
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

    public String replaceChars(final String val) {
        
        return Arrays.stream(val.split(""))
                .map(c -> this.CHAR_MAP.getOrDefault(c, c))
                .collect(Collectors.joining());

    }

    public String removeExtendedChars(String val) {
        return stripChars(val, c -> c > '\u001F' && c < '\u007F');
    }


    private String stripChars(String s, IntPredicate include) {
        return s.codePoints().filter(include::test).collect(StringBuilder::new,
                StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }

}
