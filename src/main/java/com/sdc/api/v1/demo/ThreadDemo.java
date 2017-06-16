package com.sdc.api.v1.demo;

import com.sun.jersey.api.spring.Autowire;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.concurrent.*;

/**
 * Created by Administrator on 2017/3/14.
 */
@Autowire
@Path("/resource1")
public class ThreadDemo {


//    ExecutorService pool = Executors.newFixedThreadPool(100);
//    ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//
//    @GET
//    public void t1() {
//        /**
//         * runnable
//         */
//        pool.execute(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });
//        /**
//         * callable
//         */
//        FutureTask<String> task = new FutureTask<String>(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                return "";
//            }
//        });
//        pool.execute(task);
//        try {
//            task.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//    }

}
