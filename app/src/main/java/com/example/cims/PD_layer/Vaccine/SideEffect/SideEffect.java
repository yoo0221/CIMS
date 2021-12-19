package com.example.cims.PD_layer.Vaccine.SideEffect;

import com.example.cims.PD_layer.Alert.Notice;

public class SideEffect {
    private String symptom;
    private String treatment;
    private int getSymptom;
    private double occurProbability;

    public SideEffect(String symptom, String treatment, int getSymptom, double occurProbability){
        this.symptom = symptom;
        this.treatment = treatment;
        this.getSymptom = getSymptom;
        this.occurProbability = occurProbability;
    }

    public void makeNotice(){
        Notice message = new Notice("백신 정보", "백신 부작용 정보");
        message.createAlert("추가");
    }

    public String getSymptom() {
        return symptom;
    }

    public String getTreatment() {
        return treatment;
    }

    public int getGetSymptom() {
        return getSymptom;
    }

    public double getOccurProbability() {
        return occurProbability;
    }
}
