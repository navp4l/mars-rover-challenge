package com.covesta.technical.utils;

/**
 * Utility class to calculate the direction of the rover from
 * its current direction and orientation of its rotation
 */
public class DirectionCalculator {

    /**
     * Will calculate the direction of the rover based on the currentDirection
     * and rotation parameters
     *
     * @param currentDirection
     * @param negativeRotation
     * @return a char value - N or S or E or W
     */

    public static char getNewDirection (char currentDirection, boolean negativeRotation) {

        char newDirection = currentDirection;

        if(currentDirection == 'N' && negativeRotation) {
            newDirection = 'W';
        } else if(currentDirection == 'N' && !negativeRotation) {
            newDirection = 'E';
        } else if(currentDirection == 'S' && negativeRotation) {
            newDirection = 'E';
        } else if(currentDirection == 'S' && !negativeRotation) {
            newDirection = 'W';
        } else if(currentDirection == 'E' && negativeRotation) {
            newDirection = 'N';
        } else if(currentDirection == 'E' && !negativeRotation) {
            newDirection = 'S';
        } else if(currentDirection == 'W' && negativeRotation) {
            newDirection = 'S';
        } else if(currentDirection == 'W' && !negativeRotation) {
            newDirection = 'N';
        }

        return newDirection;
    }

}
