package com.coherentsolutions.training.aqa.java.web.nikonova.parser;

import com.coherentsolutions.training.aqa.java.web.nikonova.shop.Cart;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.testng.Assert.*;

public class JsonParserTest {

    @Test
    public void testJSonParserWriteToFile() {
        JsonParser jsonParser = new JsonParser();
        jsonParser.writeToFile(new Cart("CartItem"));
        Path path = Paths.get("src/main/resources/CartItem.json");
        assertTrue(Files.exists(path), String.format("File %s doesn't exist", path));
    }

    @Test
    public void testJSonParserReadFromFile() {
        JsonParser jsonParser = new JsonParser();
        assertNotNull(jsonParser.readFromFile(new File("src/main/resources/CartItem.json")), "File doesn't exist");
    }

    @Test
    public void testCartForNull() {
        assertThrows(NullPointerException.class, () -> {
            JsonParser jsonParser = new JsonParser();
            jsonParser.writeToFile(null);
        });
    }

    @Test
    public void testReadFromFile() {
        assertThrows(NoSuchFileException.class, () -> {
            JsonParser jsonParser = new JsonParser();
            jsonParser.readFromFile(new File("testReadFromFile.txt"));
        });
    }

    @AfterClass
    public void clearFolder() {
        Arrays.stream(new File("src/main/resources").listFiles()).forEach(File::delete);
    }
}


