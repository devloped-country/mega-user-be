package com.mega.controller;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {

    private Map<String, Controller> mappings = new HashMap<>();

    public HandlerMapping() {
    }

    public Controller getController(String path) {
        return mappings.get(path);
    }
}
