package com.example.cims.PD_layer.Alert;

public class Notice {
    private String category;
    private String description;


    public Notice(String category, String description){
        this.category = category;
        this.description = description;
    }

    public void createAlert(String method){
        String title = category + "카테고리 수정";
        String content = description + "의 내용이 " + method + "되었습니다.";


    }
}
