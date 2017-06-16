package com.sdc.system.spring.mybatis.interceptor;

/**
* description: 
*
*
* @author today zhaojintian@ediankai.com
* @date 2016年12月17日
* @Company: ediankai
*/
public class SqlLog {
	
	//类型
	private String Type;
	//内容
	private String NewContent;
	//旧内容
	private String OldContent;
	//创建时间
	private String CreateTime;
	//修改时间
	private String ModifyTime;
	
	/**
	 * @return the type
	 */
	public String getType() {
		return Type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		Type = type;
	}
	/**
	 * @return the newContent
	 */
	public String getNewContent() {
		return NewContent;
	}
	/**
	 * @param newContent the newContent to set
	 */
	public void setNewContent(String newContent) {
		NewContent = newContent;
	}
	/**
	 * @return the oldContent
	 */
	public String getOldContent() {
		return OldContent;
	}
	/**
	 * @param oldContent the oldContent to set
	 */
	public void setOldContent(String oldContent) {
		OldContent = oldContent;
	}
	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return CreateTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
	/**
	 * @return the modifyTime
	 */
	public String getModifyTime() {
		return ModifyTime;
	}
	/**
	 * @param modifyTime the modifyTime to set
	 */
	public void setModifyTime(String modifyTime) {
		ModifyTime = modifyTime;
	}
	
	
	
}
