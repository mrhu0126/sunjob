package com.example.mapper;

import com.example.pojo.UserInfo;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    public List<UserInfo> findall();

}
