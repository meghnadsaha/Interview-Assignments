//package com.coding.altimetrik;
//
//
//import java.io.*;
//import java.math.*;
//import java.security.*;
//import java.text.*;
//import java.util.*;
//import java.util.concurrent.*;
//import java.util.function.*;
//import java.util.regex.*;
//import java.util.stream.*;
//
//import static java.util.stream.Collectors.joining;
//import static java.util.stream.Collectorslectors.toList;
//
//import java.net.*;
//
//import org.json.simple.*;
//import org.json.simple.parser.*;
//
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.net.URLConnection;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import java.net.URLEncoder;
//import java.nio.charset.StandardCharsets;
//
//class Result {
//
//    /*
//     * Complete the 'getPhoneNumbers' function below.
//     *
//     * The function is expected to return a STRING.
//     * The function accepts following parameters:
//     *  1. STRING country
//     *  2. STRING phoneNumber
//     * Base URL for copy/paste: https://jsonmock.hackerrank.com/api/countries?name=country
//
//     */
//
//    public static String getPhoneNumbers ( String country , String phoneNumber ) throws IOException, ParseException {
//        String url = "https://jsonmock.hackerrank.com/api/countries?name=" + country;
//        URL apiUrl = new URL(url);
//        URLConnection conn = apiUrl.openConnection();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//        StringBuilder responseBuilder = new StringBuilder();
//        String line;
//        while ((line = reader.readLine()) != null) {
//            responseBuilder.append(line);
//        }
//        reader.close();
//
//        JSONParser parser = new JSONParser();
//        JSONObject jsonResponse = (JSONObject) parser.parse(responseBuilder.toString());
//        JSONArray dataArray = (JSONArray) jsonResponse.get("data");
//
//        if (dataArray.isEmpty()) {
//            return "-1";
//        }
//
//        JSONObject countryObject = (JSONObject) dataArray.get(0);
//        JSONArray callingCodes = (JSONArray) countryObject.get("callingCodes");
//        String callingCode = (String) callingCodes.get(callingCodes.size() - 1);
//
//        return "+" + callingCode + " " + phoneNumber;
//    }
//
//}
//
//public class GetPhoneNumbers {
//    public static void main ( String[] args ) throws IOException, ParseException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String country = bufferedReader.readLine();
//        String encodedCountry = URLEncoder.encode(country , StandardCharsets.UTF_8.toString());
//        String phoneNumber = bufferedReader.readLine();
//
//        String result = Result.getPhoneNumbers(encodedCountry , phoneNumber);
//
//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
//}
