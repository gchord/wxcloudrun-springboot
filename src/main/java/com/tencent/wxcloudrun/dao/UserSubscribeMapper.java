package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.UserSubscribe;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserSubscribeMapper {

   Integer selectByAppIdUserId(UserSubscribe userSubscribe);

   Integer deleteByAppIdUserId(UserSubscribe userSubscribe);

   void insert(UserSubscribe userSubscribe);
}
