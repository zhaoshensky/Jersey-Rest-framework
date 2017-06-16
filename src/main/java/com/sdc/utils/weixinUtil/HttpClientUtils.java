package com.sdc.utils.weixinUtil;

import java.util.concurrent.TimeUnit;

import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;



public class HttpClientUtils {
	private static final PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
	static {
		// Increase max total connection to 200
		cm.setMaxTotal(50);
		// Increase default max connection per route to 20
		cm.setDefaultMaxPerRoute(20);
		Thread demo=new Thread(new IdleConnectionMonitorThread(cm));
		demo.setDaemon(true);
		demo.start();
	}
	
	public static  CloseableHttpClient createHttpClient(){
		CloseableHttpClient httpClient=HttpClients.custom().setConnectionManager(cm).build();
	    return httpClient;
	}
	
	public static class IdleConnectionMonitorThread implements Runnable {

        private final HttpClientConnectionManager connMgr;
        private volatile boolean shutdown;

        public IdleConnectionMonitorThread(HttpClientConnectionManager connMgr) {
            super();
            this.connMgr = connMgr;
        }

        @Override
        public void run() {
			try {
				while (!shutdown) {
					synchronized (this) {
						wait(5000);
						// 关闭失效的连接
						connMgr.closeExpiredConnections();
						// 可选的, 关闭30秒内不活动的连接
						connMgr.closeIdleConnections(50, TimeUnit.SECONDS);
					}
				}
			} catch (InterruptedException ex) {
				// terminate
			}
		}
    }
}
