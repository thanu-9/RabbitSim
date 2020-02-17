package com.spartaglobal.team2.rabbitsimulator;
import java.util.ArrayList;

public class RabbitContainer {
    private ArrayList<MaleRabbit> maleRabbits = new ArrayList<>();
    private ArrayList<FemaleRabbit> femaleRabbits = new ArrayList<>();
    public RabbitContainer(){
        this.maleRabbits.add(new MaleRabbit());
        this.femaleRabbits.add(new FemaleRabbit());
    }
    public ArrayList<MaleRabbit> getMaleRabbits(){
        return maleRabbits;
    }
    public ArrayList<FemaleRabbit> getFemaleRabbits() {
        return femaleRabbits;
    }
    public long getNumberOfMales(){
        return getMaleRabbits().size();
    }
    public long getNumberOfFemales(){
        return getFemaleRabbits().size();
    }

    public void birthMaleRabbit(){
        this.maleRabbits.add(new MaleRabbit());
    }
    public void birthFemaleRabbit(){
        this.femaleRabbits.add(new FemaleRabbit());
    }
/*    public long checkIsDead(){
        long deathToll = 0;
        for (MaleRabbit r : maleRabbits){
            if(r.getAge()>=60){
                maleRabbits.remove(r);
                deathToll++;
            }
        }
        for (FemaleRabbit r : femaleRabbits){
            if(r.getAge()>=60){
                femaleRabbits.remove(r);
                deathToll++;
            }
        }
        return deathToll;
    }*/
    public void increaseAge() {
        for (MaleRabbit r : maleRabbits) {
            r.increaseAge();
        }
        for (FemaleRabbit r : femaleRabbits) {
            r.increaseAge();
        }
    }
}

