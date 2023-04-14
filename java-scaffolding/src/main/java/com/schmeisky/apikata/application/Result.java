package com.schmeisky.apikata.application;

import java.util.List;
import java.util.Map;

public class Result {

    private final List<Map<String, String>> results;

    public Result(final List<Map<String, String>> results) {
        this.results = results;
    }

    public List<Map<String, String>> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "Result{" +
                "results=" + results +
                '}';
    }
}
