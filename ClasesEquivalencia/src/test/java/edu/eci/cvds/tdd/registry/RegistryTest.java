package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();
    @Test
    public void validateRegistryResult() {
        Person person = new Person();
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }
    // TODO Complete with more test cases
    @Test
    public void validateAliveVoter(){
        Person person = new Person();
        person.setAlive(false);
        RegisterResult result = registry.AliveVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }
    @Test
    public void validateDuplicateVote(){
        Person person = new Person();
        person.setAge(21);
        person.setAlive(true);
        RegisterResult result = registry.registerVoter(person);
        RegisterResult result2 = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DUPLICATED, result2);
    }
    @Test
    public void validateUnderAge(){
        Person person = new Person();
        person.setAge(5);
        RegisterResult result = registry.UnderAgeVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }
    @Test
    public void validateInvalidAge(){
        Person person = new Person();
        person.setAge(-1);
        RegisterResult result = registry.invalidAge(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }

    @Test
    public void validatenNotDuplicateVote(){
        Person person = new Person();
        RegisterResult result = registry.registerVoter(person);
        Assert.assertNotEquals(RegisterResult.DUPLICATED, result);
    }
    
}