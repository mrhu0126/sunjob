package com.mapper;

import com.pojo.Dep;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DepMapper {

    @Select("select depid , depname from dep")
    public List<Dep> findall();

    @Select("select count(*) from dep")
    public int findCount();

    @Select("select depid , depname from dep where depname like #{depame}")
    public List<Dep> like(String depname);


}
