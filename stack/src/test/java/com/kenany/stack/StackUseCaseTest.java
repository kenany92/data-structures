package com.kenany.stack;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class StackUseCaseTest {

    StackUseCase useCase;

    List<String> inputList;

    List<String> outputList;

    @Before
    public void setUp() throws Exception{

        useCase = new StackUseCase();

        ClassLoader classLoader = getClass().getClassLoader();

        File fileInput = new File(classLoader.getResource("input.txt").getFile());
        File fileOutput = new File(classLoader.getResource("output.txt").getFile());

        if (!fileInput.exists()) {
            throw new FileNotFoundException("Input file not found");
        }

        if (!fileOutput.exists()) {
            throw new FileNotFoundException("Output file not found");
        }

        inputList = Files.readAllLines(Paths.get(fileInput.toURI()));

        outputList = Files.readAllLines(Paths.get(fileOutput.toURI()));
    }

    @Test
    public void checkBalanced() {

        for (int i = 0; i < inputList.size(); i++) {

            String input = inputList.get(i);

            boolean ouput = Boolean.valueOf(outputList.get(i));

            boolean balanced = useCase.checkBalanced(input);

            System.out.println("Input:  " + input);

            System.out.println("Output:  " + ouput);

            assertEquals("The retrieved value equals to expected", balanced, ouput);
        }
    }
}
