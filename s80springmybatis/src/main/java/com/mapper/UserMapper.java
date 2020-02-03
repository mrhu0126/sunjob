package com.mapper;

import com.pojo.UserInfo;

import java.util.List;

public interface UserMapper {

    public List<UserInfo> findall();
    public int deletebyusername(String username);
    public int add(UserInfo userInfo);

}
