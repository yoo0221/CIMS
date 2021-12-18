package com.example.cims.PD_layer.Alert;

public class Notice {
    private String category;
    private String description;
    public Notice(String category, String description){
        this.category = category;
        this.description = description;
        //Notification Builder함수 추가해서 알림 바로 전송
        createAlert();
    }
    public void createAlert(){

    }
}
