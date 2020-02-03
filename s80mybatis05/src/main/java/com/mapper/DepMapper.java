package com.mapper;

import com.pojo.Dep;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DepMapper {

    public List<Dep> findall();
    // 一个参数可以不用@Param
    public List<Dep> findbyqj(@Param("x") int x , @Param("y") int y);
    public List<Dep> findbyqj2(Map map);
    public List<Dep> fenye(Map map);

}
