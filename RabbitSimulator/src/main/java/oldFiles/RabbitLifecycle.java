package oldFiles;

import oldFiles.FemaleRabbit;
import oldFiles.MaleRabbit;
import oldFiles.RabbitContainer;

import java.util.ArrayList;
import java.util.Random;

public class RabbitLifecycle {//int months to run array
    public RabbitContainer rabbitContainer = new RabbitContainer();
    long deathToll = 0;


    public RabbitContainer getRabbitContainer() {
        return rabbitContainer;
    }

    public long getNumberOfRabbits() {
        return rabbitContainer.getNumberOfMales() + rabbitContainer.getNumberOfFemales();
    }

    public long getNumberOfMales() {
        return rabbitContainer.getNumberOfMales();
    }

    public long getNumberOfFemales() {
        return rabbitContainer.getNumberOfFemales();
    }

    public long getNumberOfDeadRabbits() {
        return deathToll;
    }

    public void increaseRabbitAge() { // management of time
        for (int i = 0; i < rabbitContainer.getNumberOfMales(); i++) { //every rabbit age increases by a month
            rabbitContainer.getMaleRabbits().get(i).increaseAge();
        }
        for (int i = 0; i < rabbitContainer.getNumberOfFemales(); i++) {
            rabbitContainer.getFemaleRabbits().get(i).increaseAge();
        }
        rabbitDemise();
    }

    public void increaseTime(int time) throws InterruptedException { //set to sleep
        for (int i = 0; i < time; i++) {
            increaseRabbitAge();
            impregnateRabbits();
            birthRabbits();
            Thread.sleep(10); //1000
        }
    }

    public long getDeathToll() {
        return deathToll;
    }

    public void rabbitDemise() {
        ArrayList<MaleRabbit> toRemoveMale = new ArrayList<>();
        ArrayList<FemaleRabbit> toRemoveFemale = new ArrayList<>();
        for (MaleRabbit r : rabbitContainer.getMaleRabbits()) {
            if (r.getAge() >= 60) {
                toRemoveMale.add(r);
            }
        }
        for (FemaleRabbit r : rabbitContainer.getFemaleRabbits()) {
            if (r.getAge() >= 60) {
                toRemoveFemale.add(r);
            }
        }
        rabbitContainer.getMaleRabbits().removeAll(toRemoveMale);
        rabbitContainer.getFemaleRabbits().removeAll(toRemoveFemale);
        deathToll = toRemoveFemale.size() + toRemoveMale.size();
    }

    public boolean impregnateRabbits() {
        if (rabbitContainer.getNumberOfMales() > 0) {
            for (MaleRabbit m : rabbitContainer.getMaleRabbits()) {
                if (m.isMature()) {
                    for (FemaleRabbit f : rabbitContainer.getFemaleRabbits()) {
                        if (f.isMature() && !f.isPregnant()) {
                            f.setPregnant(true);
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public void birthRabbits() {
        Random randomLitter = new Random();
        Random randomGender = new Random();
        int toBeBirthedMale = 0;
        int toBeBirthedFemale = 0;
        final int MAX_LITTER = 14;
        final int MIN_LITTER = 1;

        String[] gender = {"m", "f"};
        for (FemaleRabbit f : rabbitContainer.getFemaleRabbits()) {
            if (f.isPregnant()) {
                int litter = randomLitter.nextInt(MAX_LITTER - MIN_LITTER) + MIN_LITTER;
                for (int i = 1; i <= litter; i++) {
                    int newGender = randomGender.nextInt(gender.length);
                    if (newGender == 0) {
                        toBeBirthedMale++;
                    } else {
                        toBeBirthedFemale++;
                    }
                }
                f.setPregnant(false);
            }
        }
        for(int i = 1; i <= toBeBirthedMale; i++){
            rabbitContainer.birthMaleRabbit();
        }
        for(int i = 1; i <= toBeBirthedFemale; i++){
            rabbitContainer.birthFemaleRabbit();
        }
    }
}