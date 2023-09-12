package com.mega.controller.survey;

import com.mega.controller.Controller;
import com.mega.controller.HandlerMapping;
import com.mega.controller.survey.controller.TestController;


import java.util.HashMap;
import java.util.Map;

public class SurveyHandlerMapping extends HandlerMapping {

    private Map<String, Controller> mappings = new HashMap<>();

    public SurveyHandlerMapping() {
        mappings.put("/test.do", new TestController());
    }

    @Override
    public Controller getController(String path) {
        return mappings.get(path);
    }
}
