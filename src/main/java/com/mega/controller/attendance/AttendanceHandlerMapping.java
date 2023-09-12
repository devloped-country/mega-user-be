package com.mega.controller.attendance;

import com.mega.controller.Controller;
import com.mega.controller.HandlerMapping;
import com.mega.controller.attendance.controller.TestController;

import java.util.HashMap;
import java.util.Map;

public class AttendanceHandlerMapping extends HandlerMapping {

    private Map<String, Controller> mappings = new HashMap<>();

    public AttendanceHandlerMapping() {
        mappings.put("/test.do", new TestController());
    }

    @Override
    public Controller getController(String path) {
        return mappings.get(path);
    }
}
