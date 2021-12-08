package com.example.cims.VaccineInfo;

import com.example.cims.VaccineInfo.SideEffectInfo.SideEffect;

import java.util.ArrayList;

public class Vaccine {
    private String name;
    private int vaccinated = 0;
    private int dead = 0;
    private ArrayList<SideEffect> sideEffects;
    public Vaccine(String name, int vaccinated, int dead){
        this.name = name;
        this.vaccinated = vaccinated;
        this.dead = dead;
        this.sideEffects = new ArrayList<SideEffect>();
    }
    public void appendSideEffect(SideEffect sideEffect){
        sideEffects.add(sideEffect);
    }
    public void requestSideInfo() {

    }
}

