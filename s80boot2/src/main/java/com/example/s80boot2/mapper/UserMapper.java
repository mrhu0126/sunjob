package com.example.s80boot2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.s80boot2.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<UserInfo> {

}
