package com.mega.controller.curriculum;

import com.mega.controller.Controller;
import com.mega.controller.HandlerMapping;
import com.mega.controller.curriculum.controller.TestController;

import java.util.HashMap;
import java.util.Map;

public class CurriculumHandlerMapping extends HandlerMapping {

    private Map<String, Controller> mappings = new HashMap<>();

    public CurriculumHandlerMapping() {
        mappings.put("/test.do", new TestController());
    }

    @Override
    public Controller getController(String path) {
        return mappings.get(path);
    }
}

