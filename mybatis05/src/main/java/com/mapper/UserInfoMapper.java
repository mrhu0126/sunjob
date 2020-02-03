package com.mapper;

import com.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;

public interface UserInfoMapper {

    public int save(UserInfo userInfo);

}
