package com.example.oneserverwebflux.model.request;

public record SearchRequest(Integer pageNo, Integer numOfRows, String name, String iso) {
}
