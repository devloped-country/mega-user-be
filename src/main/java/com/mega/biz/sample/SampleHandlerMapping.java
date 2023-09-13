package com.mega.biz.sample;

import com.mega.common.controller.Controller;
import com.mega.common.controller.HandlerMapping;
import com.mega.biz.sample.controller.GetSampleListController;
import com.mega.biz.sample.controller.InsertSampleController;
import com.mega.biz.sample.controller.InsertSampleFormController;

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
