package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class IMaoApp implements Serializable {

    private Long id;

    private String appId;

    private String appName;

    private String appLogo;

    private String appPath;

    private String appDesc;

    private Integer sort;

    private Integer isSub;

    private String bookStartTime;

    private String bookEndTime;

    private String rushStartTime;

    private String rushEndTime;
}
