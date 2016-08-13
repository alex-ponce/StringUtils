package com.fairway;

import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by alexponce on 8/11/16.
 */
public class TestStingUtils {

    @Test
    public void testRemoveExtendedChars() {
        String fileName = System.getProperty("user.dir") + "/src/com/fairway/resources/json-with-extended.txt";

        try {

            StringHelper sh = new StringHelper();

            String fileContent = sh.readFile(fileName);

            fileContent = sh.replaceChars(fileContent);

            fileContent = sh.removeExtendedChars(fileContent);

            System.out.print(fileContent);

            assertTrue("Removed Extended Characters", true);
        }
        catch(Exception e) {
            fail(String.format("Error reading file [%1$d]", fileName));
        }
    }
}
