package com.mega.biz.attendance;

import com.mega.common.controller.Controller;
import com.mega.common.controller.HandlerMapping;
import com.mega.biz.attendance.controller.TestController;

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
