package com.example.deliverybackend.controller;

import com.example.deliverybackend.api.ExchangeRateUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeRateController {

    @GetMapping("/exchange-rate")
    public String getExchangeRate() {
        JSONArray exchangeRates = ExchangeRateUtils.getExchangeRate();
        // JSON 배열을 문자열로 변환하여 반환
        return exchangeRates.toString();
    }
}
