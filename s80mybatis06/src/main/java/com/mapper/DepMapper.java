package com.mapper;

import com.pojo.Dep;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DepMapper {

    @Select("select depid ,depname from dep")
    public List<Dep> findall();



}
