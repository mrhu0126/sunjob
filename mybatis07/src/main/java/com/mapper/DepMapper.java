package com.mapper;

import com.pojo.Dep;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DepMapper {

    public List<Dep> findall();
    public Dep findbyid(int depid);
    public List<Dep> find(@Param("depid")int depid , @Param("depname") String depname);

   // <!-- 注解的方式 -->
    @Select("select depid , depname from dep")
    @ResultMap("dep")
    public List<Dep> find2();

}
