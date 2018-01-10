package com.covesta.technical.utils;

import org.junit.Assert;

public class DirectionCalculatorTest {

    @org.junit.Test
    public void getNewDirectionTest() {
        Assert.assertEquals('W', DirectionCalculator.getNewDirection('N', true));
        Assert.assertEquals('E', DirectionCalculator.getNewDirection('N', false));
        Assert.assertEquals('E', DirectionCalculator.getNewDirection('S', true));
        Assert.assertEquals('W', DirectionCalculator.getNewDirection('S', false));
        Assert.assertEquals('S', DirectionCalculator.getNewDirection('W', true));
        Assert.assertEquals('N', DirectionCalculator.getNewDirection('W', false));
        Assert.assertEquals('N', DirectionCalculator.getNewDirection('E', true));
        Assert.assertEquals('S', DirectionCalculator.getNewDirection('E', false));
    }
}