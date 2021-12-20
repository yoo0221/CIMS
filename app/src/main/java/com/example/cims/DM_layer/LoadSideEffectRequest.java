package com.example.cims.DM_layer;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoadSideEffectRequest extends StringRequest{
    final static private String URL = "http://yoo0221.ivyro.net/side_effect_load.php";
    private Map<String, String> map;

    public LoadSideEffectRequest(int vac_id, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        map = new HashMap<>();
        map.put("vac_id", vac_id+"");
    }

    protected Map<String, String> getParams() throws AuthFailureError{
        return map;
    }
}
