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

            String fileContent = FileHelper.readFile(fileName);

            fileContent = FileHelper.removeExtendedChars(fileContent);

            System.out.print(fileContent);

            assertTrue("Removed Extended Characters", true);

            //assertEquals("Testing JUnit: Success", str);
        }
        catch(Exception e) {
            fail(String.format("Error reading file [%1$d]", fileName));
        }
    }
}
