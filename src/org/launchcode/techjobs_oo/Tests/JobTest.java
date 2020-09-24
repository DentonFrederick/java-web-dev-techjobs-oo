package org.launchcode.techjobs_oo.Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

public class JobTest {
    private Job job;

    @Before
    public void makeJob(){
        job = new Job( "Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        Assert.assertTrue(job1.getId() == job2.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Assert.assertEquals("Product tester", this.job.getName());
        Assert.assertEquals("ACME", this.job.getEmployer());
        Assert.assertEquals("Desert", this.job.getLocation());
        Assert.assertEquals("Quality control", this.job.getPositionType());
        Assert.assertEquals("Persistence", this.job.getCoreCompetency());
    }

}
