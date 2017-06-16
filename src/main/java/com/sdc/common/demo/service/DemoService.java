package com.sdc.common.demo.service;

import java.util.HashMap;
import java.util.List;

import com.sdc.common.demo.model.Demo;



public interface DemoService 
{
	//redis demo
	public void demoRedis() throws Exception;
	//cache demo
	public String demoCache(int ppp) throws Exception;
	//cache mongo
	public void demoMongo() throws Exception;
	public void insertMongo(HashMap hm);

}
