package com.covesta.technical.utils;

import com.covesta.technical.domain.State;

/**
 * Utility class to calculate the position of the rover from
 * its current state - x, y coordinates and direction
 */
public class PositionCalculator {

    /**
     * Will calculate the position of the rover based on its current state
     * @param initialState
     * @return updated state @see com.covesta.technical.domain.State of the Rover
     */
    public static State getNewPosition (State initialState) {

        char initialStateX = initialState.getX();
        char initialStateY = initialState.getY();
        char initialStateDirection = initialState.getDirection();

        char finalStateX = initialStateX;
        char finalStateY = initialStateY;

        if (initialStateDirection == 'S') {
            finalStateY--;
        } else if (initialStateDirection == 'N') {
            finalStateY++;
        } else if (initialStateDirection == 'E') {
            finalStateX++;
        } else if (initialStateDirection == 'W') {
            finalStateX--;
        }

        return new State(finalStateX, finalStateY, initialStateDirection);
    }

}
