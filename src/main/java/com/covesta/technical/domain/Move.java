package com.covesta.technical.domain;

import com.covesta.technical.utils.PositionCalculator;

public class Move extends BaseInput {

    public Move(State initialState) {
        super(initialState);
    }

    public void execute() {
        //'M' means move forward one grid point, and maintain the same heading
        finalState = PositionCalculator.getNewPosition(initialState);
    }
}
