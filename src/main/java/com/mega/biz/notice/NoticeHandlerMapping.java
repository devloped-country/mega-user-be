package com.mega.biz.notice;

import com.mega.common.controller.Controller;
import com.mega.common.controller.HandlerMapping;
import com.mega.biz.notice.controller.TestController;


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
