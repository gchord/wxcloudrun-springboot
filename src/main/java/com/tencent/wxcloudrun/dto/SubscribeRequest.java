package com.tencent.wxcloudrun.dto;

import lombok.Data;

@Data
public class SubscribeRequest {

    private String appId;

    private String wxId;

    private String action;
}
