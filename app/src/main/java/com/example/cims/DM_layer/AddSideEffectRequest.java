package com.example.cims.DM_layer;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class AddSideEffectRequest extends StringRequest{
    final static private String URL = "http://yoo0221.ivyro.net/side_effect_upload.php";
    private Map<String, String> map;

    public AddSideEffectRequest(int vac_id, String symtom, String treatment, int getsym, double occurprob, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        map = new HashMap<>();
        map.put("vac_id", vac_id+"");
        map.put("symtom", symtom);
        map.put("treatment", treatment);
        map.put("getsym", getsym + "");
        map.put("occurprob", occurprob + "");
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
