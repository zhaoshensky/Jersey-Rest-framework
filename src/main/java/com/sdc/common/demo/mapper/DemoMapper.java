package com.sdc.common.demo.mapper;

import com.sdc.common.demo.model.Demo;
import com.sdc.utils.BaseMapper;
import java.util.List;

public interface DemoMapper extends BaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Demo record);

    Demo selectByPrimaryKey(Integer id);

    List<Demo> selectAll();

    int updateByPrimaryKey(Demo record);
}