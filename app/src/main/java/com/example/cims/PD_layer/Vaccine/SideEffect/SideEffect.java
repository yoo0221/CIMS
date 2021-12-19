package com.example.cims.PD_layer.Vaccine.SideEffect;

import com.example.cims.PD_layer.Alert.Notice;

public class SideEffect {
    private String symptom;
    private String treatment;
    private int getSymptom;
    private double occurProbability;

    public SideEffect(String symptom, String treatment, int getSymptom){
        this.symptom = symptom;
        this.treatment = treatment;
        this.getSymptom = getSymptom;
    }

    //public getOccurProbability(){
        //this.occurProbability = this.getSymptom / 백신object.getvaccinated();
    //}

    public void makeNotice(){
        Notice message = new Notice("백신 정보", "백신 부작용 정보");
        message.createAlert("추가");

    }
}
