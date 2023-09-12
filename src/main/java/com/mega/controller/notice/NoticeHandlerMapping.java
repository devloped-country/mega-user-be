package com.mega.controller.notice;

import com.mega.controller.Controller;
import com.mega.controller.HandlerMapping;
import com.mega.controller.notice.controller.TestController;


import java.util.HashMap;
import java.util.Map;

public class NoticeHandlerMapping extends HandlerMapping {

    private Map<String, Controller> mappings = new HashMap<>();

    public NoticeHandlerMapping() {
        mappings.put("/test.do", new TestController());
    }

    @Override
    public Controller getController(String path) {
        return mappings.get(path);
    }
}
