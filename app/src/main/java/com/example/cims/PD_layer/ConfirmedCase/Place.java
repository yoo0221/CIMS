package com.example.cims.PD_layer.ConfirmedCase;

import com.example.cims.PD_layer.ConfirmedCase.VisitedRecord.VisitRecord;

public class Place {

    private double lat;
    private double lng;
    private VisitRecord visitRecord;

    public Place(double lat, double lng){
        this.lat = lat;
        this.lng = lng;
    }

    public void appenRecord(VisitRecord visitRecord){
        this.visitRecord = visitRecord;
    }

    public void requestRecordsInfo(){

    }

    public void addToMap(){
        //place.lat, place.lng => map에 마커 추가
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public VisitRecord getVisitRecord() {
        return visitRecord;
    }
}
