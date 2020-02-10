package com.jetbrains;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;


public class APIHelper {
    private final String clientId = "d4e9830832787b74844195a806a95e27";
    private final String clientSecret = "9e405949dca1213a2826330e819f3bfc8b5645b5c62c0f7610f2deb6e9ae7b97";
    private static APIHelper apiManager = null;

    private APIHelper() {

    }

    public static APIHelper getInstance() {
        if (apiManager == null)
            apiManager = new APIHelper();

        return apiManager;
    }

    public void request(SourceCode sourceCode) {

        try {
            URL url = new URL("https://api.jdoodle.com/v1/execute");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            String input = "{\"clientId\": \"" + clientId + "\",\"clientSecret\":\"" + clientSecret + "\",\"script\":\"" + sourceCode.toString() +
                    "\",\"language\":\"" + sourceCode.getLanguage().getName() + "\",\"versionIndex\":\"" + sourceCode.getLanguage().getVersionIndex() + "\"} ";


            System.out.println(input);

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(input.getBytes());
            outputStream.flush();


            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Please check your inputs : HTTP error code : " + connection.getResponseCode());
            }

            BufferedReader bufferedReader;
            bufferedReader = new BufferedReader(new InputStreamReader(
                    (connection.getInputStream())));

            String output;
            System.out.println("Output from JDoodle .... \n");
            while ((output = bufferedReader.readLine()) != null) {
                System.out.println(output);
            }

            connection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}