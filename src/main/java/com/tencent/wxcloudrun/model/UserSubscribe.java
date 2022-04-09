package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class UserSubscribe implements Serializable {

    private Long id;

    private String wxId;

    private String appId;

    private LocalDateTime createTime;
}
