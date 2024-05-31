package com.example.deliverybackend.controller;


import com.example.deliverybackend.api.NaverStoreCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreAndMenuController {

    @Autowired
    private NaverStoreCrawler naverStoreCrawler;

    @GetMapping("/crawl")
    public String crawlData() {
        naverStoreCrawler.process();
        return "크롤링 완료";
    }
}
