package com.sdc.utils.weixinUtil;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 创建人：user 创建时间：2013-10-16 修改人：user 修改时间：2013-10-16 类描述： 修改备注： 版本:
 * 
 */

public class Pagination extends com.sdc.utils.weixinUtil.page.Pagination{

	private static final long serialVersionUID = 5853471654402644440L;
	public static final String ASC = "asc";
	public static final String DESC = "desc";
	private String orderBy;
	private String order;
	private int pageSize = 10;
	private int pageShow = -1;
	private int totalPage = 1;
	private int totalRecord = 0;
	private int currentPage = 1;
	private Map<String, Integer> limit = new HashMap<String, Integer>();
	private Map<String, String[]> params = new HashMap<String, String[]>();// 分页的请求参数
	private Map<String, String> query = new HashMap<String, String>();
	private Map<String, Object> queryOtherParam = new HashMap<String, Object>();
	public Map<String, Object> getQueryOtherParam() {
		return queryOtherParam;
	}
	public void setQueryOtherParam(Map<String, Object> queryOtherParam) {
		this.queryOtherParam = queryOtherParam;
	}

	/**
	 * 存放当前用户所属商户的编码列表
	 * 李大海 添加
	 */
	private Map<String, Object> sysCodeMap = new HashMap<String, Object>();
	private String actionUrl;// 分页的请求路径
	@SuppressWarnings("unchecked")
	private Collection items;
	private Boolean isCheckPageNo = true;

	private int maxPage = 0;

	/**
	 * 初始化用户所属商户的编码列表
	 * 李大海 添加
	 */
	public Pagination(List<String> sysCodeList) {
		if(sysCodeList!=null&&sysCodeList.size()>0){
			this.sysCodeMap.put("sysCodes",sysCodeList);
		}else{
			//加一个不可能存在的商户编码
			this.sysCodeMap.put("sysCodes",sysCodeList.add("0000000000"));
		}
		
	}
	public Pagination() {
	}

	public Pagination(int pageSize) {
		this.pageSize = pageSize;
	}

	public Pagination(Boolean isCheckPageNo) {
		this.isCheckPageNo = isCheckPageNo;
	}

	@SuppressWarnings("unchecked")
	public Collection getItems() {
		return items;
	}

	@SuppressWarnings("unchecked")
	public void setItems(Collection items) {
		this.items = items;
	}

	public String getActionUrl() {
		return actionUrl;
	}

	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}

	/**
	 * @param currentPage
	 *            当前页
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		this.getParams().put("pageNo", new String[] { currentPage + "" });
	}

	/**
	 * @param currentPage
	 *            当前页
	 */
	public void setCurrentPage(int currentPage, int maxPage) {
		if (currentPage > maxPage) {
			currentPage = maxPage;
		}
		this.maxPage = maxPage;
		this.currentPage = currentPage;
		this.getParams().put("pageNo", new String[] { currentPage + "" });
	}

	/**
	 * @param totalRecord
	 *            总记录数
	 */
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord < 0 ? 0 : totalRecord;
		initPage();
	}

	/**
	 * @param pageSize
	 *            每页记录数
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize < 0 ? 0 : pageSize;
		params.put("pageSize",new String[] {""+this.pageSize } );
		initPage();
	}

	/**
	 * 设定分页列表中显示的数量
	 * 
	 * @param pageShow
	 */
	public void setPageShow(int pageShow) {
		this.pageShow = pageShow;
	}

	private void initPage() {
		if (getPageSize() == 0) {
			totalPage = 1;
		} else {
			if (getTotalRecord() == 0) {
				totalPage = 1;
			} else {
				totalPage = getTotalRecord() / getPageSize();
			}
			if (getTotalRecord() > 0
					&& ((getTotalRecord() % getPageSize()) != 0)) {
				totalPage = totalPage + 1;
			}
		}
	}

	/**
	 * @return 总页数
	 */
	public int getTotalPage() {
		if (getPageSize() == 0) {
			totalPage = 1;
		} else {
			if (getTotalRecord() == 0) {
				totalPage = 1;
			} else {
				totalPage = getTotalRecord() / getPageSize();
			}
			if (getTotalRecord() > 0
					&& ((getTotalRecord() % getPageSize()) != 0)) {
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
	 * @return 当前页面 如果小于0则返回最后一页
	 */
	public int getCurrentPage() {
		if (isCheckPageNo) {
			if (currentPage < 0 || currentPage > getTotalPage()) {
				return getTotalPage();
			} else if (currentPage == 0) {
				return 1;
			} else {
				String str[] = params.get("pageNo");
				if (str != null) {
					currentPage = Integer.parseInt(str[0]);
				}
				return currentPage;
			}
		} else {
			return currentPage;
		}
	}

	/**
	 * @return 每页的记录数
	 */
	public int getPageSize() {
		if (pageSize < 1 && params.get("pageSize") == null) {
			pageSize = 10;
		} else {
			if (params.get("pageSize") != null) {
				pageSize = Integer.parseInt(params.get("pageSize")[0]);
			} else if(pageSize<1){
				pageSize = 10;
			}
		}
		return pageSize;
	}

	/**
	 * @return 分页列表显示的页面数量
	 */
	public int getPageShow() {
		if (pageShow < 0) {
			pageShow = 10;
		}
		return pageShow;
	}

	/**
	 * @return 下一页
	 */
	public int getNextPage() {
		return isLast() ? getTotalPage() : getCurrentPage() + 1;
	}

	/**
	 * @return 上一页
	 */
	public int getPrevPage() {
		return isFirst() ? 1 : getCurrentPage() - 1;
	}

	/**
	 * @return 当前页面的最后一条记录
	 */
	public int getLastRecord() {
		return isLast() ? getTotalRecord() : getCurrentPage() * getPageSize();
	}

	/**
	 * @return 当前页面的第一条记录
	 */
	public int getStartRecord() {
		return isFirst() ? 1 : (getCurrentPage() - 1) * getPageSize() + 1;
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
	public int[] getPageIndexs() {
		int[] pageList = new int[getTotalPage()];
		for (int i = 0; i < getTotalPage(); i++) {
			pageList[i] = i + 1;
		}
		return pageList;
	}

	/**
	 * @return 当局部显示页面索引时，能够显示的页面索引
	 */
	public int[] getShowPageIndexs() {
		// 设定起始页
		int firstShowPage = getCurrentPage() - getPageShow() / 2;
		if (firstShowPage <= 0) {
			firstShowPage = 1;
		}
		// 设定终止页
		int endShowPage = firstShowPage + getPageShow();
		if (endShowPage > getTotalPage()) {
			endShowPage = getTotalPage();
			if (endShowPage - pageShow > 0
					&& endShowPage - getPageShow() < firstShowPage) {
				firstShowPage = endShowPage - getPageShow();
			}
		}
		int showPageIndexs[] = new int[endShowPage - firstShowPage + 1];
		int index = 0;
		for (int showPageIndex = firstShowPage; showPageIndex <= endShowPage; showPageIndex++) {
			showPageIndexs[index] = showPageIndex;
			index++;
		}
		return showPageIndexs;
	}

	/**
	 * @return 当前显示的页面索引中是否显示了首页
	 */
	public boolean isShowFirst() {
		if (getCurrentPage() - getPageShow() / 2 > 0) {
			return true;
		}
		return false;
	}

	/**
	 * @return 当前显示的页面索引中是否显示了尾页
	 */
	public boolean isShowLast() {
		if (getCurrentPage() + getPageShow() / 2 < getTotalPage()) {
			return true;
		}
		return false;
	}

	public Map<String, String[]> getParams() {
		return params;
	}

	public void setParams(Map<String, String[]> params) {
		this.params = params;
		getQuery();
	}

	/**
	 * 添加别的参数
	 * 
	 * @return
	 */
	public Map<String, Object> queryOtherParam() {
		return queryOtherParam;
	}

	public Map<String, String> getQuery() {
		if (params != null) {
			for (String key : params.keySet()) {
				String[] vs = params.get(key);
				Set<String> s = new HashSet<String>();
				for (String v : vs) {
					if (!s.contains(v)) {
						s.add(v);
						query.put(key, v);
					}
				}
			}
		}
		return query;
	}

	public Map<String, Integer> getLimit() {
		if (params.get("pageNo") == null) {
			limit.put("start", 0);
            limit.put("end", this.getPageSize());
		} else {
			limit.put("start", (Integer.parseInt(params.get("pageNo")[0]) - 1)
					* getPageSize());
			limit.put("end", getPageSize());

		}
		return limit;
	}

	public void setLimit(Map<String, Integer> limit) {
		this.limit = limit;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
		this.addParam("orderBy", orderBy);
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
		this.addParam("order", order);
	}

	public Integer getPageStart() {
		// 当前的页码是从1开始记数
		return (this.currentPage - 1) * this.pageSize;
	}

	public Integer getFirst() {
		Map<String, Integer> limit = getLimit();
		return limit.get("start");
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> setQueryParam(Map params) {
		return queryOtherParam = params;
	}

	public Pagination addParam(String K, Object V) {
		this.queryOtherParam.put(K, V);
		return this;
	}

	/**
	 * 工具方法：根据最大页数 计算最大记录数
	 * 
	 * @return
	 */
	public Integer getMaxRecord() {
		return this.pageSize * this.maxPage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public Map<String, Object> getSysCodeMap() {
		return sysCodeMap;
	}

	public void setSysCodeMap(Map<String, Object> sysCodeMap) {
		this.sysCodeMap = sysCodeMap;
	}
	
	

}
