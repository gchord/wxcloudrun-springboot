package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.IMaoAppMapper;
import com.tencent.wxcloudrun.dao.UserSubscribeMapper;
import com.tencent.wxcloudrun.model.IMaoApp;
import com.tencent.wxcloudrun.model.UserSubscribe;
import com.tencent.wxcloudrun.service.IMaoAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class IMaoAppServiceImpl implements IMaoAppService {

    @Autowired
    IMaoAppMapper iMaoAppMapper;

    @Autowired
    UserSubscribeMapper userSubscribeMapper;

    @Override
    public List<IMaoApp> selectList(String wxId, String orderAction, Integer isOfficial) {
        return iMaoAppMapper.selectList(wxId, orderAction, isOfficial);
    }

    public void insertSubscribe(String wxId, String appId) {
        UserSubscribe userSubscribe = new UserSubscribe();
        userSubscribe.setAppId(appId);
        userSubscribe.setWxId(wxId);
        userSubscribe.setCreateTime(LocalDateTime.now());

        Integer count = userSubscribeMapper.selectByAppIdUserId(userSubscribe);
        if (count == 0) {
            userSubscribeMapper.insert(userSubscribe);
        }
    }

    @Override
    public void deleteSubscribe(String wxId, String appId) {
        UserSubscribe userSubscribe = new UserSubscribe();
        userSubscribe.setAppId(appId);
        userSubscribe.setWxId(wxId);
        userSubscribeMapper.deleteByAppIdUserId(userSubscribe);
    }
}
