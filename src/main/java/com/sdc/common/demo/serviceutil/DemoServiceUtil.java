package com.sdc.common.demo.serviceutil;

import java.util.List;

import com.sdc.common.demo.model.Demo;



public interface DemoServiceUtil 
{
	int deleteByPrimaryKey(Integer id);

    int insert(Demo record);

    Demo selectByPrimaryKey(Integer id);

    List<Demo> selectAll();

    int updateByPrimaryKey(Demo record);

}
