package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.model.IMaoApp;
import com.tencent.wxcloudrun.service.IMaoAppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IMaoAppController {

    Logger logger = LoggerFactory.getLogger(CounterController.class);

    @Autowired
    IMaoAppService iMaoAppService;

    @GetMapping(value = "/api/apps")
    ApiResponse get(@RequestParam("wxId") String wxId) {
        logger.info("/api/apps get request");
        List<IMaoApp> iMaoAppList = iMaoAppService.selectList(wxId);
        return ApiResponse.ok(iMaoAppList);
    }

    @PostMapping(value = "/api/user/subscribe")
    ApiResponse postSubscribe(@RequestParam("wxId") String wxId,
                          @RequestParam("appId") String appId) {
        logger.info("/api/user/subscribe post");
        iMaoAppService.insertSubscribe(wxId, appId);
        return ApiResponse.ok();
    }

    @DeleteMapping(value = "/api/user/subscribe")
    ApiResponse deleteSubscribe(@RequestParam("wxId") String wxId,
                          @RequestParam("appId") String appId) {
        logger.info("/api/user/subscribe delete");
        iMaoAppService.deleteSubscribe(wxId, appId);
        return ApiResponse.ok();
    }
}
