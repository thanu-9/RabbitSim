package com.spartaglobal.team2.rabbitsimulator;

public class FemaleRabbit extends Rabbit {
    private boolean isPregnant = false;

    public FemaleRabbit() {
        super();
        super.setGender("f");
    }

    public boolean isPregnant() {
        return isPregnant;
    }

    public void setPregnant(boolean pregnant) {
        isPregnant = pregnant;
    }
}
