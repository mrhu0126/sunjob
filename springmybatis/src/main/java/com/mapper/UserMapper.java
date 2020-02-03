package com.mapper;

import com.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {
    public List<UserInfo> findall();
    public int add(UserInfo userInfo);
    public int deletebyid(String username);
}
