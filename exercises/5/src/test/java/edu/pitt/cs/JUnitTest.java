package edu.pitt.cs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JUnitTest {
    @Test
    public void testGetRoundString() {
        DrunkCarnivalShooter shooter = DrunkCarnivalShooter.createInstance(InstanceType.IMPL);
        assertEquals("Round #0:  ||    ||    ||    ||  ", shooter.getRoundString());
    }
}
