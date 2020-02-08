package com.jetbrains;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


public class APIHelper {
    private final String API_KEY = "206b7b76d9mshb6be6765ab68d57p192c16jsn39b47c2f5337";
    private static APIHelper apiManager = null;

    private APIHelper(){

    }

    public static APIHelper getInstance(){
        if(apiManager == null)
            apiManager  = new APIHelper();

        return apiManager;
    }

    public HttpResponse<JsonNode> request(String language,String sourceCode){

        HttpResponse<JsonNode> response = null;
        try {
            response = (HttpResponse<JsonNode>)  Unirest.post("https://paiza-io.p.rapidapi.com/runners/create?")
                    .header("language","java")
                    .header("source_code","public class Main {public static void main(String args[]){System.out.println(\"Hello, World\");}}")
                    .header("x-rapidapi-host", "paiza-io.p.rapidapi.com")
                    .header("x-rapidapi-key", API_KEY)
                    .header("content-type", "application/x-www-form-urlencoded")
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return response;

    }

    public HttpResponse<JsonNode> getDetails (String id){


        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.get("https://paiza-io.p.rapidapi.com/runners/get_details?id="+id)
                    .header("x-rapidapi-host", "paiza-io.p.rapidapi.com")
                    .header("x-rapidapi-key", API_KEY)
                    .asJson();
        }catch (UnirestException e) {
            e.printStackTrace();
        }

        return response;

    }
}
