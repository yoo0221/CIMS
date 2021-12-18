package com.example.cims.PD_layer.ConfirmedCase;

import com.example.cims.PD_layer.ConfirmedCase.VisitedRecord.VisitRecord;

public class Place {
    private int lat;
    private int lng;
    private VisitRecord visitRecords;
    public Place(int lat, int lng, String vistedDate, String placeName, String address){
        this.lat = lat;
        this.lng = lng;
        this.visitRecords = new VisitRecord(vistedDate, placeName, address);
    }
    public void requestRecordsInfo(){

    }
    public void addToMap(){
        //place.lat, place.lng => map에 마커 추가
    }
}
