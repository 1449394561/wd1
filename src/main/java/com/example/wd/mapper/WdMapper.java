package com.example.wd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.wd.entity.Wd;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WdMapper extends BaseMapper<Wd> {
    List<Wd> findAll(Integer id);

    @Select("select password from wd where name=#{name}")
    Wd selectByName(String name);
}
