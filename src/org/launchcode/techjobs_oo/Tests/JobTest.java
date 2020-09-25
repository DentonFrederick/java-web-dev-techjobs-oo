package org.launchcode.techjobs_oo.Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

public class JobTest {
    private Job sampleJob;
    private Job job1;
    private Job job2;
    private Job testJob1;
    private Job testJob2;
    private Job emptyFields;


    @Before
    public void makeJob() {
        job1 = new Job();
        job2 = new Job();
        sampleJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        emptyFields = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
    }

    @Test
    public void testSettingJobId() {

        Assert.assertEquals(job1.getId(), job2.getId(), 1);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Assert.assertTrue(sampleJob instanceof Job);
        Assert.assertEquals("Product tester", this.sampleJob.getName());
        Assert.assertTrue(sampleJob.getEmployer() instanceof Employer);
        Assert.assertTrue(sampleJob.getLocation() instanceof Location);
        Assert.assertTrue(sampleJob.getPositionType() instanceof PositionType);
        Assert.assertTrue(sampleJob.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Assert.assertFalse(testJob1.getId() == testJob2.getId());
    }

    @Test
    public void testForBlankLines() {
        Assert.assertEquals('\n', sampleJob.toString().charAt(0));
        Assert.assertEquals('\n', sampleJob.toString().charAt(sampleJob.toString().length() - 1));
    }

    @Test
    public void testEachFieldFilledOut() {
        String testingString = "\nID:" + sampleJob.getId() +
                "\nName: Product tester" +
                "\nEmployer: ACME" +
                "\nLocation: Desert" +
                "\nPosition Type: Quality control" +
                "\nCore Competency: Persistence" +
                "\n";
        Assert.assertEquals(testingString, sampleJob.toString());
    }
    @Test
    public void testNoEmptyFields(){
        String testingString = "\nID: " + emptyFields.getId() +
                "\nName: " + "Data not available" +
                "\nEmployer: " + "Data not available" +
                "\nLocation: " + "Data not available" +
                "\nPosition Type: " + "Data not available" +
                "\n";
        Assert.assertEquals(testingString, emptyFields.toString());
    }
    @Test
    public void testIdOnly(){
        String testingString = "No jobs exist";
        Assert.assertEquals(testingString, emptyFields.toString());
    }

}
