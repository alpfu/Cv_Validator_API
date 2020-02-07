package com.jetbrains;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import org.json.JSONObject;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        APIHelper apiManager = APIHelper.getInstance();
        Decoder decoderManager = Decoder.getInstance();
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter language");
        String language = scan.nextLine().toLowerCase();
        System.out.println("Enter source code");
        String sourceCode = scan.nextLine();
        System.out.println(sourceCode);
        String encodedSourceCode = decoderManager.encodeValue(sourceCode);

        System.out.println(a);

        HttpResponse<JsonNode> response =  apiManager.request(language,encodedSourceCode);
        JSONObject object = decoderManager.getJSON(response);

        String error = decoderManager.getError(object);

        if(error == null){
            String id = decoderManager.getID(object);
            String status = decoderManager.getStatus(object);

            response = apiManager.getDetails(id);
            object = decoderManager.getJSON(response);


        }

    }
}
