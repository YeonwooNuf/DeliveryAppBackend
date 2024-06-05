package com.example.deliverybackend.service.search;

import com.example.deliverybackend.entity.search.Menu;
import com.example.deliverybackend.repository.search.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    private final SearchRepository searchRepository;

    @Autowired
    public SearchService(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    public List<Menu> searchMenus(String keyword) {
        return searchRepository.searchByKeyword(keyword);
    }
}

