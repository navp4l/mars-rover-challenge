package com.covesta.technical.domain;

/**
 * Abstract class from which all input command classes are derived.
 * Forces implementation of execute method on its sub classes.
 */
public abstract class BaseInput {

    protected State initialState;
    protected State finalState;

    public BaseInput(State initialState) {
        this.initialState = initialState;
    }

    public State getFinalState() {
        return finalState;
    }

    /**
     * Execute the command and change the state of the rover's position
     */
    abstract public void execute();

}
