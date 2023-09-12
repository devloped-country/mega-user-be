package com.mega.controller.inquiry;

import com.mega.controller.Controller;
import com.mega.controller.HandlerMapping;
import com.mega.controller.inquiry.controller.TestController;


import java.util.HashMap;
import java.util.Map;

public class InquiryHandlerMapping extends HandlerMapping {

    private Map<String, Controller> mappings = new HashMap<>();

    public InquiryHandlerMapping() {
        mappings.put("/test.do", new TestController());
    }

    @Override
    public Controller getController(String path) {
        return mappings.get(path);
    }
}
