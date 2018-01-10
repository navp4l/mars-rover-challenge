package com.covesta.technical.domain;

import com.covesta.technical.utils.DirectionCalculator;

public class Right extends BaseInput {

    public Right(State initialState) {
        super(initialState);
    }

    public void execute() {
        //'R' makes the rover spin 90 degrees right
        finalState = new State(initialState.getX(), initialState.getY(), DirectionCalculator.getNewDirection(initialState.getDirection(), false));
    }
}
