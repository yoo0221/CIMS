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
        Notice message = new Notice("확진자 카테고리", "방문 장소가 업데이트 되었습니다.");
    }
}
