package com.hackatum.swipewatcher.ui.main.Backend;

import com.google.gson.Gson;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class Networking {


    private static final String URL = "http://131.159.210.198:8080";

    public static void main(String[] args) {
        //addLiked("test");
    }

    public static boolean isMatch(String title) throws IOException {
        title = title.replaceAll(" ", "");
        String result = sendHttpGETRequest("isMatch/" + title);
        return result.equals("true");
    }

    public static void addLiked(String title) throws IOException {
        title = title.replaceAll(" ", "");
        sendHttpGETRequest("addLiked/" + title);
    }

    public static ArrayList<String> getLiked() throws IOException {
        String result = sendHttpGETRequest("showLiked");

        Gson gson = new Gson();
        String[] strings = gson.fromJson(result, String[].class);

        return new ArrayList<String>(Arrays.asList(strings));
    }

    private static String sendHttpGETRequest(String dings) throws IOException {

        String url = URL + "/" + dings;

        URL obj = new URL(url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) obj.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            return response.toString();
        } else {
            System.out.println("GET request not worked");
            return "fehler";
        }


    }


}