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


    @Before
    public void makeJob(){
        job1 = new Job();
        job2 = new Job();
        sampleJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId(){
        Assert.assertEquals(job1.getId(), job2.getId(), 1);
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Assert.assertTrue(sampleJob instanceof Job);
        Assert.assertEquals("Product tester", this.sampleJob.getName());
        Assert.assertTrue(this.sampleJob.getEmployer() != null);
        Assert.assertTrue(this.sampleJob.getLocation() != null);
        Assert.assertTrue(this.sampleJob.getPositionType() != null);
        Assert.assertTrue(this.sampleJob.getCoreCompetency() != null);
    }
    @Test
    public void testJobsForEquality(){
        Assert.assertTrue(testJob1.getId() == testJob2.getId());
    }

}
