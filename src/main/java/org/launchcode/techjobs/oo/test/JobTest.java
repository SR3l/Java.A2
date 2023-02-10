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
        Job tempJob1 = new Job("Data Scientist",new Employer("Tesla"),new Location("Alaska"),new PositionType("Entry level"),new CoreCompetency("A.I") );
        Job tempJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertNotEquals(tempJob1.getId(),tempJob2.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job productTester = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("Product tester", productTester.getName());
        assertEquals("ACME",productTester.getEmployer().getValue());
        assertEquals("Desert",productTester.getLocation().getValue());
        assertEquals("Quality control",productTester.getPositionType().getValue());
        assertEquals("Persistence",productTester.getCoreCompetency().getValue());

    }
    @Test
    public void testJobsForEquality(){
        Job tempJobA = new Job("Data Scientist",new Employer("Amazon"),new Location("Glendale"),new PositionType("Entry level"),new CoreCompetency("AWS") );
        Job tempJobB = new Job("Data Scientist",new Employer("Amazon"),new Location("Glendale"),new PositionType("Entry level"), new CoreCompetency("AWS"));
        assertFalse(tempJobA.equals(tempJobB));
    }
    @Test
    public  void testToStringContainsCorrectLabelsAndData(){
        Job testToString = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("\nID: "+ testToString.getId() +
                "\nName: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence" + "\n",testToString.toString());

    }
    @Test
    public void testToStringHandlesEmptyField(){
        Job job2 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("\nID: "+job2.getId() +
                "\nName: Product tester\n" +
                "Employer: Data not available\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence" + "\n",job2.toString());
    }


}
