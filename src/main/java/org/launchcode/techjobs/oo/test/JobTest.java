package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
@Test
    public void testSettingJobId(){
    Job job1 = new Job();
    Job job2 = new Job();
    assertNotEquals(job1.getId(), job2.getId());

}
@Test
    public void testJobConstructorSetsAllFields(){
    Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    assertTrue(job1.getName() instanceof String);
    assertTrue(job1.getEmployer() instanceof Employer);
    assertTrue(job1.getLocation() instanceof Location);
    assertTrue(job1.getPositionType() instanceof PositionType);
    assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);

    assertEquals(job1.getName(),"Product tester");
    assertEquals(job1.getLocation().getValue(), "Desert");
    assertEquals(job1.getEmployer().getValue(), "ACME");
    assertEquals(job1.getPositionType().getValue(), "Quality control");
    assertEquals(job1.getCoreCompetency().getValue(), "Persistence");

}
@Test
    public void testJobsForEquality(){
    Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    assertFalse(job1.equals(job2));
}

@Test
    public void testToStringStartsAndEndsWithNewLine(){
    Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

    assertEquals('\n',job1.toString().charAt(0));
    assertEquals('\n',job1.toString().charAt(job1.toString().length()-1));
}
@Test
    public void testToStringContainsCorrectLabelsAndData(){
    Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    assertEquals("\nID: "+job1.getId()+"\nName: "+ job1.getName()+ "\nEmployer: "+job1.getEmployer().getValue()+ "\nLocation: "+job1.getLocation().getValue()+"\nPosition Type: "+job1.getPositionType().getValue()+"\nCore Competency: "+job1.getCoreCompetency().getValue()+"\n",job1.toString());
}
@Test
    public void testToStringHandlesEmptyField(){
    Job job1 = new Job("", new Employer(""), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    Job job2 = new Job();
    assertEquals("\nID: "+job1.getId()+"\nName: Data not available\nEmployer: Data not available\nLocation: Data not available\nPosition Type: "+job1.getPositionType().getValue()+"\nCore Competency: "+job1.getCoreCompetency().getValue()+"\n",job1.toString());
    assertEquals("OOPS! This job does not seem to exist.",job2.toString());
}

}
