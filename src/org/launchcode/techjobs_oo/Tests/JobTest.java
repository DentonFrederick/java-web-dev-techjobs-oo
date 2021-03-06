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
    private Job idOnly;


    @Before
    public void makeJob() {
        job1 = new Job();
        job2 = new Job();
        sampleJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        emptyFields = new Job("Product tester", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        idOnly = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
    }

    @Test
    public void testSettingJobId() {
        int idDifference = job2.getId() - job1.getId();

        Assert.assertFalse(job1.getId() == job2.getId());
        Assert.assertTrue(idDifference == 1);
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
        Assert.assertTrue(emptyFields.toString().contains("Location: Data not available"));
    }
    @Test
    public void testIdOnly(){
        String testingString = "No jobs exist";
        Assert.assertEquals(testingString, idOnly.toString());
    }

}
