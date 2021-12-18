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
        Notice message = new Notice("백신 카테고리", "부작용 정보가 업데이트 되었습니다.");
    }
}
