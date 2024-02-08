
package edu.eci.cvds.tdd.registry;
import java.util.ArrayList;
public class Registry {
    ArrayList<Integer> votantes = new ArrayList<>();

    public RegisterResult registerVoter(Person p) {
        
        // TODO Validate person and return real result.
        if(votantes.contains(p.getId())){
            return RegisterResult.DUPLICATED;
        }
        if(AliveVoter(p).equals(RegisterResult.VALID) && UnderAgeVoter(p).equals(RegisterResult.VALID) && invalidAge(p).equals(RegisterResult.VALID) ){
            votantes.add(p.getId());
        }
        return RegisterResult.VALID; 
    }
    public RegisterResult AliveVoter(Person p){
        if(!p.isAlive()){
            return RegisterResult.DEAD;
        }
        return RegisterResult.VALID;
    }

    public RegisterResult UnderAgeVoter(Person p){
        if(!(p.getAge() > 18)){
            return RegisterResult.UNDERAGE;
        }
        return RegisterResult.VALID;
    }
    public RegisterResult invalidAge(Person p){
        if(p.getAge() < 0){
            return RegisterResult.INVALID_AGE;
        }
        return RegisterResult.VALID;
    }
}