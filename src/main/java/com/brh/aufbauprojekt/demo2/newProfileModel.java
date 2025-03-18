package com.brh.aufbauprojekt.demo2;

import javafx.scene.control.RadioButton;

// extends newProfile ( String profileName, int page, int psize, boolean maleToggle, boolean femaleToggle, boolean diverseToggle )
public class newProfileModel{
private String pName;
private int age;
private int size;
private int weight;
private boolean male;
private boolean female;
private boolean diverse;

public newProfileModel( String pName, int age, int size, int weight, boolean male, boolean female, boolean diverse ){
    this.pName = pName;
    this.age = age;
    this.size = size;
    this.weight = weight;
    this.male = male;
    this.female = female;
    this.diverse = diverse;
}

    public newProfileModel(String profileName, String page, String psize, String pweight, RadioButton maleToggle, RadioButton femaleToggle, RadioButton diverseToggle) {
    }

    public String getpName() {
    return pName;
}

public int getAge() {
    return age;
}

public int getSize() {
    return size;
}

public int getweight() {
        return weight;
    }

public boolean isMale() {
    return male;
}

public boolean isFemale() {
    return female;
}

public boolean isDiverse() {
    return diverse;
}

}
