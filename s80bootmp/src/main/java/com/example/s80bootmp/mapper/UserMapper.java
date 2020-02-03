package com.example.s80bootmp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.s80bootmp.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<UserInfo> {


}
