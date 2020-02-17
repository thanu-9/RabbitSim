package oldFiles;
import oldFiles.FemaleRabbit;
import oldFiles.MaleRabbit;

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
    public long getNumberOfMalesAndFemales(){
        return getFemaleRabbits().size() + getMaleRabbits().size();
    }

    public void birthMaleRabbit(){
        this.maleRabbits.add(new MaleRabbit());
    }
    public void birthFemaleRabbit(){
        this.femaleRabbits.add(new FemaleRabbit());
    }

    public void increaseAge() {
        for (MaleRabbit r : maleRabbits) {
            r.increaseAge();
        }
        for (FemaleRabbit r : femaleRabbits) {
            r.increaseAge();
        }
    }
}

