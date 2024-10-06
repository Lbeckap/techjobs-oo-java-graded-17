package org.launchcode.techjobs.oo;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;


public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Assert.assertEquals("Product tester", job.getName());

        assertEquals("ACME", job.getEmployer().getValue());

        assertEquals("Desert", job.getLocation().getValue());

        assertEquals("Quality control", job.getPositionType().getValue());

        assertEquals("Persistence", job.getCoreCompetency().getValue());

    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertNotEquals(job1, job2);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        String newline = System.lineSeparator();
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expected = newline +
                "ID: " + job1.getId() + newline +
                "Name: " + job1.getName() + newline +
                "Employer: " + job1.getEmployer().getValue() + newline +
                "Location: " + job1.getLocation().getValue() + newline +
                "Position Type: " + job1.getPositionType().getValue() + newline +
                "Core Competency: " + job1.getCoreCompetency().getValue() + newline;

        assertEquals(expected, job1.toString());
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        String newline = System.lineSeparator();
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expected = newline +
                "ID: " + job1.getId() + newline +
                "Name: " + job1.getName() + newline +
                "Employer: " + job1.getEmployer().getValue() + newline +
                "Location: " + job1.getLocation().getValue() + newline +
                "Position Type: " + job1.getPositionType().getValue() + newline +
                "Core Competency: " + job1.getCoreCompetency().getValue() + newline;

        assertEquals(expected, job1.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        String newline = System.lineSeparator();
        Job job1 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String expected = newline +
                "ID: " + job1.getId() + newline +
                "Name: " + job1.getName() + newline +
                "Employer: " + "Data not available" + newline +
                "Location: " + job1.getLocation().getValue() + newline +
                "Position Type: " + job1.getPositionType().getValue() + newline +
                "Core Competency: " + job1.getCoreCompetency().getValue() + newline;

        assertEquals(expected, job1.toString());
    }

    @Test
    public void testToStringHandlesOnlyIdNoData() {
        String newline = System.lineSeparator();
        Job job1 = new Job();

        String expected = "OOPS! This job does not seem to exist.";

        assertEquals(expected, job1.toString());
    }
}
