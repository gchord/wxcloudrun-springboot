package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.IMaoApp;

import java.util.List;

public interface IMaoAppService {

    List<IMaoApp> selectList(String wxId,String orderAction,Integer isOfficial);

    void insertSubscribe(String wxId,String appId);

    void deleteSubscribe(String wxId,String appId);
}
