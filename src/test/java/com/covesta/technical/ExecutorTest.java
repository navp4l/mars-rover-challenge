package com.covesta.technical;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Executor.class)
public class ExecutorTest {

    private final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
    private BufferedReader bf;

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outputContent));
        bf = PowerMockito.mock(BufferedReader.class);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }

    @Test
    public void testExecuteWithoutAnyInput(){
        String input = "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Executor.main(null);
        Assert.assertEquals("Enter absolute path of the input file \n" +
                "** Default file is src/main/resources/input.txt\n" +
                "Final State of Rover 1 is :: 1 3 N\n" +
                "Final State of Rover 2 is :: 5 1 E\n" +
                "Rover 3 has fallen outside the provided plateau coordinates", outputContent.toString().trim());
    }

    @Test
    public void testExecuteWithInput(){
        String input = "src/main/resources/input.txt";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Executor.main(null);
        Assert.assertEquals("Enter absolute path of the input file \n" +
                "** Default file is src/main/resources/input.txt\n" +
                "Final State of Rover 1 is :: 1 3 N\n" +
                "Final State of Rover 2 is :: 5 1 E\n" +
                "Rover 3 has fallen outside the provided plateau coordinates", outputContent.toString().trim());
    }

    @Test
    public void testExecuteWithFileNotFoundException(){
        String input = "src/main/resources/input123.txt";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Executor.main(null);
        Assert.assertTrue(outputContent.toString().contains("System Exception"));
    }

    @Test
    public void testExecuteWithIOException() throws Exception {
        String input = "src/main/resources/input.txt";
        PowerMockito.whenNew(BufferedReader.class).withAnyArguments().thenReturn(bf);
        PowerMockito.when(bf.readLine()).thenThrow(IOException.class);
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Executor.main(null);
        Assert.assertTrue(outputContent.toString().contains("System Exception"));
    }

}