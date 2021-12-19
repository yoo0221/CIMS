package com.example.cims.PD_layer.ConfirmedCase.VisitedRecord;

import com.example.cims.PD_layer.Alert.Notice;

public class VisitRecord {
    private String visitedDate;
    private String placeName;
    private String address;

    public VisitRecord(String visitedDate, String placeName, String address) {
        this.visitedDate = visitedDate;
        this.placeName = placeName;
        this.address = address;

        makeNotice();
    }

    public void makeNotice(){
        Notice message = new Notice("확진자 정보", "방문 장소 정보");
        message.createAlert("추가");
    }

    public String getVisitedDate() {
        return visitedDate;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getAddress() {
        return address;
    }
}