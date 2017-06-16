package com.sdc.system.spring.thread;

import org.springframework.core.task.TaskExecutor;

/**
* description: 
*
*
* @author today zhaojintian@ediankai.com
* @date 2017年3月17日
* @Company: ediankai
*/
public class MyTaskExecutor {

	private TaskExecutor taskExecutor;
	
    public TaskExecutor getTaskExecutor() {
        return taskExecutor;
    }

    public void setTaskExecutor(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public void printMessages(Runnable r,int i) {
    	
            taskExecutor.execute(r);
            
    }
	
	
}
