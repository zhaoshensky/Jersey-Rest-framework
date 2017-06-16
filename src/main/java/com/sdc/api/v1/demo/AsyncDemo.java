package com.sdc.api.v1.demo;

import com.sun.jersey.api.spring.Autowire;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.CompletionCallback;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.container.TimeoutHandler;
import javax.ws.rs.core.Response;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/3/14.
 */
//@Autowire
//@Path("resourceService")
public class AsyncDemo {


    ExecutorService pool = Executors.newFixedThreadPool(100);

    /**
     * 最常用简单的异步
     *
     * @param asyncResponse
     * @return
     */
    @GET
    public String async(@Suspended final AsyncResponse asyncResponse) {
        pool.execute(new Runnable() {
            @Override
            public void run() {
                String result = veryExpensiveOperation();
                asyncResponse.resume(result);
            }

            private String veryExpensiveOperation() {

                return null;
            }
        });
        return null;
    }

    /**
     * 可以设置超时时间的异步
     *
     * @param asyncResponse
     */
    @GET
    public void asyncGetWithTimeout(@Suspended final AsyncResponse asyncResponse) {
        asyncResponse.setTimeoutHandler(new TimeoutHandler() {
            @Override
            public void handleTimeout(AsyncResponse asyncResponse) {
                asyncResponse.resume(Response.status(Response.Status.SERVICE_UNAVAILABLE).entity("Operation time out.").build());
            }

        });
        asyncResponse.setTimeout(20, TimeUnit.SECONDS);
        new Thread(new Runnable() {
            @Override
            public void run() {
                String result = veryExpensiveOperation();
                asyncResponse.resume(result);
            }

            private String veryExpensiveOperation() {
                // ... very expensive operation that typically finishes within 20 seconds
                return null;
            }
        }).start();
    }


    private static int numberOfSuccessResponses = 0;
    private static int numberOfFailures = 0;
    private static Throwable lastException = null;

    /**
     * 带返回状态的
     * CompletionCallback当请求完成或执行失败,
     * ConnectionCallback当连接到一个执行客户端关闭或丢失。
     *
     * @param asyncResponse
     */
    @GET
    public void asyncGetWithCallback(@Suspended final AsyncResponse asyncResponse) {
        asyncResponse.register(new CompletionCallback() {
            @Override
            public void onComplete(Throwable throwable) {
                if (throwable == null) {
                    // no throwable - the processing ended successfully
                    // (response already written to the client)
                    numberOfSuccessResponses++;
                } else {
                    numberOfFailures++;
                    lastException = throwable;
                }
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                String result = veryExpensiveOperation();
                asyncResponse.resume(result);
            }

            private String veryExpensiveOperation() {
                // ... very expensive operation
                return null;
            }
        }).start();
    }
}

