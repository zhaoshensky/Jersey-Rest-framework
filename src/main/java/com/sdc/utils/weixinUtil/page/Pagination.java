/** **************************************************
 * Description: 分页类
 * Copyright:   Copyright (c) 2008
 * Company:    cl
 * @author     caoxl
 * @version    1.0
 * @see
 HISTORY
 *  2008-7-1 caoxl Create File
 ************************************************* */
package com.sdc.utils.weixinUtil.page;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({ "unchecked" })
public class Pagination{
		
	private static final long serialVersionUID = 5853471654402644440L;

	private static int[] pageSizeList = {5,10,20,30,40,50,100,200,500,1000};
	
	    private int pageSize = -1;
	    private int pageShow = -1;
	    
	    private int totalPage = 1;
	    private int totalRecord = 0;
	    private int currentPage = 1;
	    
	    private Map<String,Integer> limit = new HashMap<String,Integer>();
	    
	    private String actionUrl;//分页的请求路径
	    private Map<String,String[]> params = new HashMap<String,String[]>();//分页的请求参数
	    
	    private Collection items;
	    
		public Collection getItems() {
			return items;
		}
		public void setItems(Collection items) {
			this.items = items;
		}
		public String getActionUrl() {
			return actionUrl;
		}
		public void setActionUrl(String actionUrl) {
			this.actionUrl = actionUrl;
		}
		public Pagination() { }
		/**
		 * @param currentPage 当前页
		 */
		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
			params.put("pageNo", new String[] { currentPage + "" });
		}

		/**
		 * @param totalRecord 总记录数
		 */
		public void setTotalRecord(int totalRecord) {
			this.totalRecord = totalRecord < 0 ? 0 : totalRecord;
			initPage();
		}
		
		/**
		 * @param pageSize 每页记录数
		 */
		public void setPageSize(int pageSize) {
			this.pageSize = pageSize < 0 ? 0 : pageSize;
			initPage();
		}
		
		/**
		 * 设定分页列表中显示的数量
		 * @param pageShow
		 */
		public void setPageShow(int pageShow) {
			this.pageShow = pageShow;
		}
		
		private void initPage(){
			if(getPageSize() == 0){
				totalPage = 1;
			}else{
				if(getTotalRecord() == 0){
					totalPage = 1;
				}else{
					totalPage = getTotalRecord() / getPageSize();
				}
				if(getTotalRecord() > 0 && ((getTotalRecord() % getPageSize()) != 0)){
					totalPage = totalPage + 1;
				}
			}
		}


		public int[] getPageSizeList(){
			return pageSizeList;
		}
		/**
		 * @return 总页数
		 */
		public int getTotalPage() {
			if(getPageSize() == 0){
				totalPage = 1;
			}else{
				if(getTotalRecord() == 0){
					totalPage = 1;
				}else{
					totalPage = getTotalRecord() / getPageSize();
				}
				if(getTotalRecord() > 0 && ((getTotalRecord() % getPageSize()) != 0)){
					totalPage = totalPage + 1;
				}
			}
			return totalPage;
		}

		/**
		 * @return 总记录数
		 */
		public int getTotalRecord() {
			return totalRecord;
		}

		/**
		 * @return 当前页面
		 * 如果小于0则返回最后一页
		 */
		public int getCurrentPage() {
			if(currentPage < 0 || currentPage > getTotalPage()){
				return getTotalPage();
			}else if(currentPage == 0){
				return 1;
			}else{
				return currentPage;
			}
		}
		
		/**
		 * @return 每页的记录数
		 */
		public int getPageSize() {
			if(pageSize<0){
				pageSize = 20;
			}
			return pageSize;
		}

		/**
		 * @return 分页列表显示的页面数量
		 */
		public int getPageShow() {
			if(pageShow<0){
				pageShow = 10;
			}
			return pageShow;
		}
		
		/**
		 * @return 下一页
		 */
		public int getNextPage(){
			return isLast() ? getTotalPage() : getCurrentPage()+1;
		}

		/**
		 * @return 上一页
		 */
		public int getPrevPage(){
			return isFirst() ? 1 : getCurrentPage()-1;
		}
		
		/**
		 * @return 当前页面的最后一条记录
		 */
		public int getLastRecord(){
			return isLast() ? getTotalRecord() : getCurrentPage() * getPageSize();
		}
		
		/**
		 * @return 当前页面的第一条记录
		 */
		public int getStartRecord(){
			return isFirst() ? 1 : (getCurrentPage()-1) * getPageSize()+1;
		}
		
		/**
		 * @return 是否是首页
		 */
		public boolean isFirst() {
			return getCurrentPage() <= 1;
		}

		/**
		 * @return 是否是尾页
		 */
		public boolean isLast() {
			return getCurrentPage() >= getTotalPage();
		}

		/**
		 * @return 所有页面的索引值
		 */
		public int[] getPageIndexs(){
			int[] pageList = new int[getTotalPage()];
			for(int i=0;i<getTotalPage();i++){
				pageList[i] = i+1;
			}
			return pageList;
		}

		/**
		 * @return 当局部显示页面索引时，能够显示的页面索引
		 */
	    public int[] getShowPageIndexs() {
	    	//设定起始页
	    	int firstShowPage = getCurrentPage() - getPageShow() / 2;
	    	if(firstShowPage <= 0){
	    		firstShowPage = 1;
	    	}
	    	//设定终止页
        	int endShowPage = firstShowPage + getPageShow();
        	if(endShowPage > getTotalPage()){
        		endShowPage = getTotalPage();
        		if(endShowPage-pageShow>0 && endShowPage-getPageShow()<firstShowPage){
        			firstShowPage = endShowPage-getPageShow();
        		}
        	}

        	int showPageIndexs[] = new int[endShowPage-firstShowPage+1];
        	int index = 0;
        	for(int showPageIndex = firstShowPage; showPageIndex <= endShowPage; showPageIndex++){
        		showPageIndexs[index] = showPageIndex;
        		index++;
        	}
	        return showPageIndexs;
	    }
		
	    /**
	     * @return 当前显示的页面索引中是否显示了首页
	     */
	    public boolean isShowFirst(){
	    	if(getCurrentPage() - getPageShow()/2 > 0){
	    		return true;
	    	}
	    	return false;
	    }
	    
	    /**
	     * @return 当前显示的页面索引中是否显示了尾页
	     */
	    public boolean isShowLast(){
	    	if(getCurrentPage() + getPageShow()/2 < getTotalPage()){
	    		return true;
	    	}
	    	return false;
	    }
		public Map<String, String[]> getParams() {
			return params;
		}
		public void setParams(Map<String, String[]> params) {
			this.params.putAll(params);
			getQuery();
		}
		
		private Map<String,String> query = new HashMap<String,String>();
		public Map<String, String> getQuery() {
			if(params!=null) {
				for(String key : params.keySet()){
					String [] vs = params.get(key);
					Set<String> s = new HashSet();
					for(String v : vs){
						if(!s.contains(v)){
							s.add(v);
							query.put(key, v);
						}
					}
				}
			}
			return query;
		}
		
		public Map<String, Integer> getLimit() {
			if(params.get("pageNo") == null){
				limit.put("start", 0);
				limit.put("end", getPageSize());
			}else {
				limit.put("start", (Integer.parseInt(params.get("pageNo")[0])-1)*getPageSize());
				limit.put("end", getPageSize());
			}
			return limit;
		}
		public void setLimit(Map<String, Integer> limit) {
			this.limit = limit;
		}
		
		public Integer getPageNo(){
		    return this.currentPage;
		}
		
}
