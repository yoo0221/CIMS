package com.example.cims.DM_layer;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class AddVisitedRecordRequest extends StringRequest{
    final static private String URL = "http://yoo0221.ivyro.net/VisitRecordUpload.php";
    private Map<String, String> map;

    public AddVisitedRecordRequest(String visitedDate, String place, String address, double lat, double lng, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        map = new HashMap<>();
        map.put("visitedDate", visitedDate);
        map.put("place", place);
        map.put("address", address);
        map.put("lat", lat + "");
        map.put("lng", lng + "");
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
