package com.mapper;

import com.pojo.Emp;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;
import java.util.Map;

public interface EmpMapper {

    public List<Emp> findempanddep();
    public List<Map> findempanddep2();
    public List<Emp> multiquery(Map map);
    public List<Emp> in(List list);
    public int update(Emp emp);
    @Select("call findall()")
    public List<Emp> findall();

    @Select("call findbyid(#{empid})")
    public Emp findbyid(int id);

    @Select("call testadd(#{a , mode=IN , jdbcType=INTEGER} , #{b , mode=IN , jdbcType=INTEGER} , #{c ,mode=OUT , jdbcType=INTEGER})")
    @Options(statementType = StatementType.CALLABLE)
    public void testadd(Map map);

}
