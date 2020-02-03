package com.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserInfoMapper {

    @Select("select gender , count(*) as count from userinfo group by gender")
    public List<Map> findbygender();

}
