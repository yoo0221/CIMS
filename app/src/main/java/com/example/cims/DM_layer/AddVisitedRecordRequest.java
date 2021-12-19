package com.example.cims.DM_layer;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.example.cims.PD_layer.ConfirmedCase.Place;

import java.util.HashMap;
import java.util.Map;

public class AddVisitedRecordRequest extends StringRequest{
    final static private String URL = "http://yoo0221.ivyro.net/VisitRecordUpload.php";
    private Map<String, String> map;

    public AddVisitedRecordRequest(Place place, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        map = new HashMap<>();
        map.put("visitedDate", place.getVisitRecord().getVisitedDate());
        map.put("place", place.getVisitRecord().getPlaceName());
        map.put("address", place.getVisitRecord().getAddress());
        map.put("lat", place.getLat() + "");
        map.put("lng", place.getLng() + "");
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
