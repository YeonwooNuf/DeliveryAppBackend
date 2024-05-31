package com.example.deliverybackend.api;

import org.json.JSONArray;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
//환율 openAPI 받아오는 코드
@SpringBootApplication
public class ExchangeRateUtils {
    public static void main(String[] args) {
        SpringApplication.run(ExchangeRateUtils.class, args);
        System.out.println(getExchangeRate());
    }

    public static JSONArray getExchangeRate() {
        StringBuilder responseContent = new StringBuilder();
        HttpURLConnection connection = null;

        String authKey = "rDywxWYJn4fZuW5r8hCmDPX7HXy4CPwB";
        String searchDate = "20240517";//DateFormat('yyyyMMdd').format(DateTime.now()); 현재 날짜임 나중에 님들이 직접 넣어서 ㄱㄱ
        String dataType = "AP01";

        try {
            URL url = new URL("https://www.koreaexim.go.kr/site/program/financial/exchangeJSON?authkey=" + authKey + "&searchdate=" + searchDate + "&data=" + dataType);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();

            if (status > 299) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        responseContent.append(line);
                    }
                }
            } else {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        responseContent.append(line);
                    }
                }
                // 전체 환율 정보를 JSON 형식으로 변환하여 반환
                return new JSONArray(responseContent.toString());
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException | org.json.JSONException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return new JSONArray(responseContent.toString());
    }
}
