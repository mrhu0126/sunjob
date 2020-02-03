package com.mapper;

import com.pojo.Dep;
import com.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface EmpMapper {

    //找朋友
    public List<Emp> zpy(@Param("min") String min ,@Param("max") String max);
    public List<Emp> like(String name);
    public List<Emp> like2(String name);
    public int count();
    public List<Map> tj();

}
