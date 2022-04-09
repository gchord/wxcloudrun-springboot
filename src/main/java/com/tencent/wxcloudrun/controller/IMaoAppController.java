package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.SubscribeRequest;
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
    ApiResponse get(@RequestParam("wxId") String wxId,
                    @RequestParam(value = "orderAction", required = false) String orderAction,
                    @RequestParam(value = "isOfficial", required = false, defaultValue = "0") Integer isOfficial) {
        logger.info("/api/apps get request");
        List<IMaoApp> iMaoAppList = iMaoAppService.selectList(wxId, orderAction, isOfficial);
        return ApiResponse.ok(iMaoAppList);
    }

    @PostMapping(value = "/api/user/subscribe")
    ApiResponse postSubscribe(@RequestBody SubscribeRequest subReq) {
        logger.info("/api/user/subscribe " + subReq.getAction());
        if ("add".equals(subReq.getAction())) {
            iMaoAppService.insertSubscribe(subReq.getWxId(), subReq.getAppId());
        } else if ("del".equals(subReq.getAction())) {
            iMaoAppService.deleteSubscribe(subReq.getWxId(), subReq.getAppId());
        }
        return ApiResponse.ok();
    }

}
