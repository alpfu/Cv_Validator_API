package com.jetbrains;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Decoder {

    public static Decoder decoderManager = null;

    private Decoder(){

    }

    public static Decoder getInstance(){
        if (decoderManager == null);
            decoderManager = new Decoder();

            return decoderManager;
    }


    public JSONObject getJSON(HttpResponse<JsonNode> response){

        if(response == null)
            return null;
        return response.getBody().getObject();


    }

    public String getID(JSONObject object){

        String id = object.get("id").toString();
        return id;

    }

    public String getStatus(JSONObject object){

        String status = object.get("status").toString();
        return status;

    }

    public String getError(JSONObject object){

        try{
            return object.get("error").toString();
        }
        catch (JSONException e){

            return null;

        }

    }

    public static String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString()).replace("%","%25").replace("+","%20");
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }



}
