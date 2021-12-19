package com.example.cims.DM_layer;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoadVisitedRecordTableRequest extends StringRequest{
    final static private String URL = "http://yoo0221.ivyro.net/visit_record_table_load.php";
    private Map<String, String> map;

    public LoadVisitedRecordTableRequest(String visitedDate, String place, String address, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        map = new HashMap<>();
        map.put("visitedDate", visitedDate);
        map.put("place", place);
        map.put("address", address);
    }

    protected Map<String, String> getParams() throws AuthFailureError{
        return map;
    }
}
