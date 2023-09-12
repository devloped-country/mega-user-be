package com.mega.controller.sample;

import com.mega.controller.Controller;
import com.mega.controller.HandlerMapping;
import com.mega.controller.sample.controller.GetSampleListController;
import com.mega.controller.sample.controller.InsertSampleController;
import com.mega.controller.sample.controller.InsertSampleFormController;

import java.util.HashMap;
import java.util.Map;

public class SampleHandlerMapping extends HandlerMapping {

    private Map<String, Controller> mappings = new HashMap<>();

    public SampleHandlerMapping() {
        mappings.put("/getUserList.do", new GetSampleListController());
        mappings.put("/insertUserForm.do", new InsertSampleFormController());
        mappings.put("/insertUser.do", new InsertSampleController());
    }

    @Override
    public Controller getController(String path) {
        return mappings.get(path);
    }
}
