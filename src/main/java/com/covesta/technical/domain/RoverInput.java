package com.covesta.technical.domain;

/**
 * Class to construct rover input parameters
 */
public class RoverInput {

    private String[] roverInitialPosition;
    private String roverControlInput;

    public RoverInput(String[] roverInitialPosition, String roverControlInput) {
        this.roverInitialPosition = roverInitialPosition;
        this.roverControlInput = roverControlInput;
    }

    /**
     * Returns the final state of the Rover after all the provided commands have
     * completed execution. Execution follows the first in first out principle.
     * @return updatedState @State
     */
    public State executeCommand() {
        State initialState = new State(roverInitialPosition[0].charAt(0), roverInitialPosition[1].charAt(0), roverInitialPosition[2].charAt(0));
        State finalState = null;
        BaseInput input = null;
        char[] chars = roverControlInput.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == 'L') {
                input = new Left(initialState);
            } else if (c == 'R') {
                input = new Right(initialState);
            } else if (c == 'M') {
                input = new Move(initialState);
            }
            input.execute();
            initialState = input.getFinalState();
            if (i == chars.length - 1) finalState = initialState;
        }
        return finalState;
    }

}
