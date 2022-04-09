package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.IMaoApp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IMaoAppMapper {

   List<IMaoApp> selectList(@Param("wxId") String wxId);
}
