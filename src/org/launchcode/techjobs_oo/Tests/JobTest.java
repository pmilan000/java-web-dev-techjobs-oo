package org.launchcode.techjobs_oo.Tests;

import org.junit.*;
import static org.junit.Assert.*;
import org.launchcode.techjobs_oo.*;

public class JobTest {

    private Job job1, job2, job3, job4;

    @Before
    public void setJobObjects() {
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

    }

    @After
    public void clearJobObjects() {
        Job.resetNextId();
    }

    @Test
    public void testSettingJobId() {
    assertFalse(job1.getId() == job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(job3 instanceof Job);
        assertEquals(3, job3.getId());
        assertEquals("Product tester", job3.getName());
        assertEquals("ACME", job3.getEmployer().getValue());
        assertEquals("Desert", job3.getLocation().getValue());
        assertEquals("Quality control", job3.getPositionType().getValue());
        assertEquals("Persistence", job3.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(job3.equals(job4));
    }

    @Test
    public void testJobsToString() {
        String output = "\nID: " + job3.getId() + "\n" +
                "Name: " + job3.getName() + "\n" +
                "Employer: " + job3.getEmployer().getValue() + "\n" +
                "Location: " + job3.getLocation().getValue() + "\n" +
                "Position Type: " + job3.getPositionType().getValue() + "\n" +
                "Core Competency: " + job3.getCoreCompetency().getValue() + "\n";
        assertEquals(output, job3.toString());
    }
}
