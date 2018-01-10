package com.covesta.technical.utils;

import com.covesta.technical.domain.State;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PositionCalculatorTest {

    @Test
    public void getNewPositionTest() {
        Assert.assertEquals(PositionCalculator.getNewPosition(new State('1', '3', 'N')).toString(), new State('1', '4', 'N').toString());
        Assert.assertEquals(PositionCalculator.getNewPosition(new State('1', '3', 'S')).toString(), new State('1', '2', 'S').toString());
        Assert.assertEquals(PositionCalculator.getNewPosition(new State('1', '3', 'W')).toString(), new State('0', '3', 'W').toString());
        Assert.assertEquals(PositionCalculator.getNewPosition(new State('1', '3', 'E')).toString(), new State('2', '3', 'E').toString());
    }
}