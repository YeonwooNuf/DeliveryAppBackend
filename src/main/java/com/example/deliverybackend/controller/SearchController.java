package com.example.deliverybackend.controller;

import com.example.deliverybackend.entity.search.Menu;
import com.example.deliverybackend.service.search.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SearchController {
    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Menu>> searchMenus(@RequestParam String keyword) {
        List<Menu> menus = searchService.searchMenus(keyword);
        if (menus == null || menus.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(menus);
    }
}
