package com.covesta.technical;

import com.covesta.technical.domain.RoverInput;
import com.covesta.technical.domain.State;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Executor class which reads user input from console and then
 * processes the corresponding File for input commands finally
 * outputting the end state of each rover.
 */

public class Executor {

    public static final String UPPER_COORDS_REGEX = "[0-9] [0-9]";
    public static final String INITIAL_POSITION_REGEX = "[0-9] [0-9] [NSEW]";
    public static final String INPUT_REGEX = "[LRM]*";

    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Enter absolute path of the input file \n" +
                "** Default file is src/main/resources/input.txt");

        //Read file path from console or default to preset file in resources folder

        String inputFilePath = inputScanner.nextLine();
        if(inputFilePath.length() == 0){
            inputFilePath = new Executor().getClass().getClassLoader().getResource("input.txt").getFile();
        }

        File inputFile = new File(inputFilePath);

        String[] upperCoords = null;
        String[] initialPosition = null;
        String roverControlInput = null;

        List<RoverInput> roversInput = new ArrayList<>();

        try (BufferedReader bf = new BufferedReader(new FileReader(inputFile))) {

            String currentLine;

            //Check against regex patterns to classify each line of input

            while ((currentLine = bf.readLine()) != null) {
                RoverInput input = null;
                if (currentLine.matches(UPPER_COORDS_REGEX)) {
                    upperCoords = currentLine.split(" ");
                } else if (currentLine.matches(INITIAL_POSITION_REGEX)) {
                    roverControlInput = null;
                    initialPosition = currentLine.split(" ");
                } else if (currentLine.matches(INPUT_REGEX)) {
                    roverControlInput = currentLine;
                }

                //Create and Add rover input object
                if (initialPosition != null && roverControlInput != null) {
                    input = new RoverInput(initialPosition, roverControlInput);
                    roversInput.add(input);
                }
            }

            //Iterate through rover input objects and output the final state of the rover
            int roverNumber = 1;
            for (RoverInput input : roversInput) {
                State finalState = input.executeCommand();
                if (Integer.parseInt(String.valueOf(finalState.getX())) > Integer.parseInt(upperCoords[0]) || (Integer.parseInt(String.valueOf(finalState.getY())) > Integer.parseInt(upperCoords[1]))) {
                    System.out.println("Rover " + roverNumber + " has fallen outside the provided plateau coordinates");
                } else {
                    System.out.println("Final State of Rover " + roverNumber + " is :: " + input.executeCommand().toString());
                }
                roverNumber++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("System Exception \n");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("System Exception \n");
            e.printStackTrace();
        }

    }
}
