package com.covesta.technical.domain;

import com.covesta.technical.utils.DirectionCalculator;

public class Left extends BaseInput {

    public Left(State initialState) {
        super(initialState);
    }

    public void execute() {
        //'L' makes the rover spin 90 degrees left
        finalState = new State(initialState.getX(), initialState.getY(), DirectionCalculator.getNewDirection(initialState.getDirection(), true));
    }
}
