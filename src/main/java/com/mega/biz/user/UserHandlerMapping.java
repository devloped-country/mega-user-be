package com.mega.biz.user;

import com.mega.common.controller.Controller;
import com.mega.common.controller.HandlerMapping;
import com.mega.biz.user.controller.TestController;


import java.util.HashMap;
import java.util.Map;

public class UserHandlerMapping extends HandlerMapping {

    private Map<String, Controller> mappings = new HashMap<>();

    public UserHandlerMapping() {
        mappings.put("/test.do", new TestController());
    }

    @Override
    public Controller getController(String path) {
        return mappings.get(path);
    }
}
