package com.mapper;

import com.pojo.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserDAO {
    public List<UserInfo> findall();
    public List<UserInfo> fenye(Map map);
}
